package com.bca.ocean.dashboard.erates.controller;

import com.bca.ocean.dashboard.erates.model.io.response.erates.InquiryEratesResponse;
import com.bca.ocean.dashboard.erates.service.ErateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocean/dashboard/")

public class ErateController {
    @Autowired
    ErateService erateService;

@GetMapping("/erates")
    public ResponseEntity<InquiryEratesResponse> getEratesByUserConfig(@RequestHeader(name = "X-Client") String xClient, @RequestHeader(name = "X-Token") String xToken){
    InquiryEratesResponse response=erateService.inquiryEratesByUserConfigResponse(xClient,xToken);
    return new ResponseEntity<>(response, response.getHttpStatusCode());
    }
}
