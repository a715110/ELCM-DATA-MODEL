package com.dodaso.ecosystem.elcm.dto.cust;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor 
public class PipelineMetricsDTO {
    int uploading;
    int validating;
    int valid;
    int submitted;
}
