package com.bca.ocean.dashboard.erates.model.io.request;


import com.bca.ocean.dashboard.erates.model.dto.EratesDto;
import com.bca.ocean.dashboard.erates.model.dto.RateOrderDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserConfigRequest {

    @JsonProperty("rate_order")
    private List<RateOrderDto> rateOrder;

}
