package com.bca.ocean.dashboard.erates.model.io.response.erates;

import com.bca.ocean.dashboard.erates.model.io.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InquiryEratesResponse extends BaseResponse {

    @JsonProperty("output_schema")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    InquiryEratesOutputSchema outputSchema;
    public InquiryEratesResponse(){
        super();
    }


}
