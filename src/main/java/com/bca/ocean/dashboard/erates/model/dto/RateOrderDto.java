package com.bca.ocean.dashboard.erates.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateOrderDto {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("favorite")
    private  String favorite;
}
