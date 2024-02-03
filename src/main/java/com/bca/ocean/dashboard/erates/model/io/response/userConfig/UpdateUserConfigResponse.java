package com.bca.ocean.dashboard.erates.model.io.response.userConfig;

import com.bca.ocean.dashboard.erates.model.io.response.BaseResponse;
import com.bca.ocean.dashboard.erates.model.io.response.erates.InquiryEratesOutputSchema;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateUserConfigResponse extends BaseResponse {

//    @JsonProperty("output_schema")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    UpdateUserConfigOutputSchema outputSchema;
    public UpdateUserConfigResponse(){
        super();
    }

}
