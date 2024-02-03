package com.bca.ocean.dashboard.erates.controller;

import com.bca.ocean.dashboard.erates.model.io.response.erates.InquiryEratesResponse;
import com.bca.ocean.dashboard.erates.service.ErateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocean/dashboard/")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001","http://localhost:3002","http://localhost:3003","http://localhost:3005","http://localhost:3005","https://ocean-main-ocean-dev.apps.ocpdevgra.dti.co.id/","https://ocean-main-dev1-ocean-dev.apps.ocpdevgra.dti.co.id/","https://ocean-bd-overview-ocean-dev.apps.ocpdevgra.dti.co.id/"})
public class ErateController {
    @Autowired
    ErateService erateService;

@GetMapping("/erates")
    public ResponseEntity<InquiryEratesResponse> getEratesByUserConfig(@RequestHeader(name = "X-Client") String xClient, @RequestHeader(name = "X-Token") String xToken){
    InquiryEratesResponse response=erateService.inquiryEratesByUserConfigResponse(xClient,xToken);
    return new ResponseEntity<>(response, response.getHttpStatusCode());
    }
}
