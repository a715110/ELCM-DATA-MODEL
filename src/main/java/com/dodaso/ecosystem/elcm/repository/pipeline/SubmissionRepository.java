package com.dodaso.ecosystem.elcm.repository.pipeline;

import com.dodaso.ecosystem.elcm.entity.lookup.LkpSubmissionStatus;
import com.dodaso.ecosystem.elcm.entity.pipeline.Submission;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

  List<Submission> findByContractPackage_Id(Long packageId);

  /**
   * The oldest submission in a status (the worker's queue is first in, first out).
   */
  Optional<Submission> findFirstByStatus_CodeOrderByIdAsc(String statusCode);

  /**
   * Submissions in a status, oldest first (stale-work recovery).
   */
  List<Submission> findByStatus_CodeOrderByIdAsc(String statusCode);

  /**
   * Moves a submission from one status to another only if it is still in the first one, and stamps
   * updated_at (the heartbeat the stale check reads). Returns 1 when this caller won, 0 when
   * somebody else already changed it. This is what keeps two instances from taking the same
   * submission.
   */
  @Modifying
  @Query("UPDATE Submission s SET s.status = :to, s.updatedAt = :now WHERE s.id = :id AND s.status = :from")
  int moveStatus(@Param("id") Long id,
      @Param("from") LkpSubmissionStatus from,
      @Param("to") LkpSubmissionStatus to,
      @Param("now") LocalDateTime now);

  /**
   * Heartbeat: shows the worker is still alive on this submission.
   */
  @Modifying
  @Query("UPDATE Submission s SET s.updatedAt = :now WHERE s.id = :id")
  int touch(@Param("id") Long id, @Param("now") LocalDateTime now);

  /**
   * ADDED 2026-10-13 -- completes a review in one conditional update: EXTRACTED to REVIEWED, with
   * who completed it and when. Returns 1 when this caller won, 0 when the status had changed.
   */
  @Modifying
  @Query(
      "UPDATE Submission s SET s.status = :to, s.reviewedBy = :by, s.reviewedAt = :now, s.updatedAt = :now "
          + "WHERE s.id = :id AND s.status = :from")
  int complete(@Param("id") Long id,
      @Param("from") LkpSubmissionStatus from,
      @Param("to") LkpSubmissionStatus to,
      @Param("by") String by,
      @Param("now") LocalDateTime now);

  /**
   * ADDED 2026-10-12 -- reopens a completed review in one conditional update: REVIEWED back to
   * EXTRACTED, with who and when. Returns 1 when this caller won, 0 when the submission was no
   * longer in the "from" status (for example applied in the meantime).
   */
  @Modifying
  @Query(
      "UPDATE Submission s SET s.status = :to, s.reopenedBy = :by, s.reopenedAt = :now, s.updatedAt = :now "
          + "WHERE s.id = :id AND s.status = :from")
  int reopen(@Param("id") Long id,
      @Param("from") LkpSubmissionStatus from,
      @Param("to") LkpSubmissionStatus to,
      @Param("by") String by,
      @Param("now") LocalDateTime now);

  /**
   * ADDED 2026-10-12 -- declines a submission in one conditional update: the status moves from
   * "from" to DECLINED with the reason, who and when, only if it is still in "from". Returns 1 when
   * this caller won, 0 when someone else changed it first (a Retry, for example).
   */
  @Modifying
  @Query("UPDATE Submission s SET s.status = :to, s.declineReason = :reason, s.declinedBy = :by, "
      + "s.declinedAt = :now, s.updatedAt = :now WHERE s.id = :id AND s.status = :from")
  int decline(@Param("id") Long id,
      @Param("from") LkpSubmissionStatus from,
      @Param("to") LkpSubmissionStatus to,
      @Param("reason") String reason,
      @Param("by") String by,
      @Param("now") LocalDateTime now);

  /**
   * ADDED 2026-10-14 -- every submission of a package that is not a draft, newest first, with the
   * package, its workspace, status and target record loaded in the same query. Feeds the work
   * queue, which keeps the first (newest) submission it sees for each package.
   */
  @Query(
      "SELECT s FROM Submission s JOIN FETCH s.contractPackage p JOIN FETCH p.workspace "
          + "JOIN FETCH p.status JOIN FETCH s.status LEFT JOIN FETCH p.targetRecord "
          + "WHERE p.status.code <> 'ASSEMBLY' ORDER BY s.id DESC")
  List<Submission> findForWorkQueue();

  /**
   * ADDED 2026-10-14 -- the submissions made by one person (login id compared without regard to
   * case), newest first, with the package, workspace, statuses and target record loaded. Feeds the
   * My Submissions screen.
   */
  @Query(
      "SELECT s FROM Submission s JOIN FETCH s.contractPackage p JOIN FETCH p.workspace "
          + "JOIN FETCH s.status LEFT JOIN FETCH p.targetRecord "
          + "WHERE LOWER(s.submittedBy) = LOWER(:login) ORDER BY s.id DESC")
  List<Submission> findBySubmitterDetailed(@Param("login") String login);

  /**
   * ADDED 2026-10-15 -- stale-work recovery: submissions in a status whose last heartbeat is before
   * the given time. The database does the filtering, so the usual case (nothing stale) returns no
   * rows instead of loading every PROCESSING submission.
   */
  List<Submission> findByStatus_CodeAndUpdatedAtBeforeOrderByIdAsc(
      String statusCode, LocalDateTime before);

  /**
   * ADDED 2026-10-15 -- how many submissions in a status have an id up to and including the given
   * one (queue position), counted in the database instead of loading every row.
   */
  long countByStatus_CodeAndIdLessThanEqual(String statusCode, Long id);
}