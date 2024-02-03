package com.bca.ocean.dashboard.erates.model.io.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse extends BaseResponse {

	@JsonProperty("output_schema")
	private GeneralOutputSchema outputSchema;

	public GeneralResponse() {
		super();
	}
}
