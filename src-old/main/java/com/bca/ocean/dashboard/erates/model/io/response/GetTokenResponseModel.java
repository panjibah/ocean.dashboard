package com.bca.ocean.dashboard.erates.model.io.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GetTokenResponseModel {

	@JsonProperty(value = "access_token")
    private String accessToken;
	
    @JsonProperty(value = "refresh_token")
    private String refreshToken;
    
    @JsonProperty(value = "refresh_expires_in")
    private Integer refreshExpiresIn;
    
    @JsonProperty(value = "not-before-policy")
    private Integer notBeforePolicy;
    
    @JsonProperty(value = "id_token")
    private String idToken;
    
    @JsonProperty(value = "token_type")
    private String tokenType;
    
    @JsonProperty(value = "session_state")
    private String sessionState;
    
    @JsonProperty(value = "expires_in")
    private Integer expiresIn;
    
    @JsonProperty(value = "scope")
    private String scope;

}
