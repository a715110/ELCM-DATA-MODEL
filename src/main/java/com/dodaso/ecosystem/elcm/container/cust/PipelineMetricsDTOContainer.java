package com.dodaso.ecosystem.elcm.container.cust;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.elcm.dto.AddressDTO;
import com.dodaso.ecosystem.elcm.dto.cust.PipelineMetricsDTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PipelineMetricsDTOContainer extends DataContainer<AddressDTO>{
    private PipelineMetricsDTO pipelineMetricsDTO;
}
