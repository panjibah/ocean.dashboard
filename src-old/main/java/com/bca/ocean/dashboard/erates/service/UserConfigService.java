package com.bca.ocean.dashboard.erates.service;

import com.bca.ocean.dashboard.erates.model.entity.UserConfig;
import com.bca.ocean.dashboard.erates.model.io.request.UpdateUserConfigRequest;
import com.bca.ocean.dashboard.erates.model.io.response.userConfig.UpdateUserConfigOutputSchema;
import com.bca.ocean.dashboard.erates.model.io.response.userConfig.UpdateUserConfigResponse;
import com.bca.ocean.dashboard.erates.repository.UserDashboardConfigRepository;
import com.bca.ocean.dashboard.erates.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserConfigService {
    @Autowired
    UserDashboardConfigRepository userDashboardConfigRepository;

    public UpdateUserConfigResponse updateUserConfig(String xClient, String xToken, UpdateUserConfigRequest updateUserConfigRequest) {
        UpdateUserConfigResponse customResponse = new UpdateUserConfigResponse();
        UpdateUserConfigOutputSchema outputSchema = new UpdateUserConfigOutputSchema()  ;
        UserConfig userConfig = null;
        //get new rate order
        try {
            //check rate order is 8 and
            String rateOrder = listToString(updateUserConfigRequest.getRateOrder());
            Optional<UserConfig> optionalUserConfig= userDashboardConfigRepository.findByUserIdAndCorporateId("2","2");

            if (optionalUserConfig.isPresent()){

                System.out.println("-----------------old---------------");
                userConfig = optionalUserConfig.get();
                customResponse.setHttpStatusCode(HttpStatus.OK);

            }else {
                userConfig = new UserConfig();
                System.out.println("-----------------new---------------");
                userConfig.setUserId("2");
                userConfig.setCorporateId("2");
                customResponse.setHttpStatusCode(HttpStatus.CREATED);

            }
            userConfig.setRateOrder(rateOrder);
            userDashboardConfigRepository.save(userConfig);
            outputSchema.setRateOrder(updateUserConfigRequest.getRateOrder());
        }catch (Exception e){
            System.out.println(e.toString());
            customResponse.setHttpStatusCode(HttpStatus.NOT_FOUND);
            customResponse.setError(Constants.ERRORCODE.DATANOTFOUND, Constants.ERRORMESSAGEID.DATANOTFOUND, Constants.ERRORMESSAGEEN.DATANOTFOUND);


        }
        //update/insert rate order by user id or corporate id


        //ge
        customResponse.setOutputSchema(outputSchema);
        customResponse.setError(Constants.ERRORCODE.SUCCESS, Constants.ERRORMESSAGEID.SUCCESS, Constants.ERRORMESSAGEEN.SUCCESS);
        return customResponse;
    }

    public String listToString(List<String> rateOrder){
        String resultString=String.join(",",rateOrder);
        return  resultString;
    }

    void checkRateOrder(){

    }
}
