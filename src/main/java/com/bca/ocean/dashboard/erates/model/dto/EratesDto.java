package com.bca.ocean.dashboard.erates.model.dto;

import com.bca.ocean.dashboard.erates.model.entity.Erate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
public class EratesDto{


    private String currency;
    private String bid;
    private String ask;
    private String mid;
    @JsonProperty("insert_date")
    private Date insertDate;
    private  String favorite;


}
