package com.bca.ocean.dashboard.erates.model.io.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseResponse {

    @JsonProperty("error_schema")
    protected ErrorSchema errorSchema;

    @JsonIgnore
    protected HttpStatus httpStatusCode;

    public BaseResponse() {
        this.errorSchema = new ErrorSchema();
    }

    public BaseResponse(String errorCode, String errMsgEn, String errMsgIn) {
        if (errorSchema == null) {
            this.errorSchema = new ErrorSchema();
        }
        this.errorSchema.setErrorCode(errorCode);
        this.errorSchema.setErrorMessage(new ErrorMessage(errMsgEn, errMsgIn));
    }

    public void setError(String errorCode, String errMessageId, String errMessageEn) {
        this.errorSchema = new ErrorSchema(errorCode, new ErrorMessage(errMessageId, errMessageEn));
    }

}
