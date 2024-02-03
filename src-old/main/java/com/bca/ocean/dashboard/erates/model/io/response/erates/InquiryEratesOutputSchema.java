package com.bca.ocean.dashboard.erates.model.io.response.erates;

import com.bca.ocean.dashboard.erates.model.dto.EratesDto;
import com.bca.ocean.dashboard.erates.model.entity.Erate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InquiryEratesOutputSchema {
    @JsonProperty("rates")
    private List<EratesDto> rates;
    @JsonProperty("update_date")
    private String updateDate;
}
