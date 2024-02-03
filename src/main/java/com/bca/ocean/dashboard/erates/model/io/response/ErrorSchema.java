package com.bca.ocean.dashboard.erates.model.io.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorSchema {

    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_message")
    private ErrorMessage errorMessage;

    public ErrorSchema() {
    }
}
