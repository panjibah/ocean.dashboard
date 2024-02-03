package com.bca.ocean.dashboard.erates.controller;

import com.bca.ocean.dashboard.erates.model.io.request.UpdateUserConfigRequest;
import com.bca.ocean.dashboard.erates.model.io.response.userConfig.UpdateUserConfigResponse;
import com.bca.ocean.dashboard.erates.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocean/dashboard/")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001","http://localhost:3002","http://localhost:3003","http://localhost:3005","https://ocean-main-ocean-dev.apps.ocpdevgra.dti.co.id/","https://ocean-main-dev1-ocean-dev.apps.ocpdevgra.dti.co.id/","https://ocean-bd-overview-ocean-dev.apps.ocpdevgra.dti.co.id/"})

public class UserConfigController {
 @Autowired
 UserConfigService userConfigService;

 @PutMapping("/usersConfig")
 public ResponseEntity<UpdateUserConfigResponse> updateUserConfig(@RequestHeader(value = "X-Client") String xClient, @RequestHeader(value = "X-Token") String xToken, @RequestBody UpdateUserConfigRequest updateUserConfigRequest){

  UpdateUserConfigResponse updateUserConfigResponse =  userConfigService.updateUserConfig(xClient,xToken,updateUserConfigRequest);

  return new ResponseEntity<>(updateUserConfigResponse,updateUserConfigResponse.getHttpStatusCode());
 }


}
