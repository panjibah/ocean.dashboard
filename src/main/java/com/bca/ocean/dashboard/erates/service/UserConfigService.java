package com.bca.ocean.dashboard.erates.service;

import com.bca.ocean.dashboard.erates.model.dto.EratesDto;
import com.bca.ocean.dashboard.erates.model.dto.RateOrderDto;
import com.bca.ocean.dashboard.erates.model.entity.UserConfig;
import com.bca.ocean.dashboard.erates.model.io.request.UpdateUserConfigRequest;
import com.bca.ocean.dashboard.erates.model.io.response.userConfig.UpdateUserConfigOutputSchema;
import com.bca.ocean.dashboard.erates.model.io.response.userConfig.UpdateUserConfigResponse;
import com.bca.ocean.dashboard.erates.repository.UserDashboardConfigRepository;
import com.bca.ocean.dashboard.erates.util.Constants;
import com.bca.ocean.dashboard.erates.util.error.object.RateOrder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserConfigService {
    @Autowired
    UserDashboardConfigRepository userDashboardConfigRepository;

    @Transactional
    public UpdateUserConfigResponse updateUserConfig(String xClient, String xToken, UpdateUserConfigRequest updateUserConfigRequest) {
        UpdateUserConfigResponse customResponse = new UpdateUserConfigResponse();
        UpdateUserConfigOutputSchema outputSchema = new UpdateUserConfigOutputSchema();
        UserConfig userConfig = new UserConfig();
        //get new rate order
        try {
            //check rate order is 8 and
            RateOrder rateOrder = listToString(updateUserConfigRequest.getRateOrder());
            System.out.println("tttt"+updateUserConfigRequest.getRateOrder());
            System.out.println("tttt"+rateOrder.getRateOrder());
            System.out.println("tttt"+rateOrder.getFavoriteOrder());


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
            userConfig.setRateOrder(rateOrder.getRateOrder().toString());
            userConfig.setFavorite(rateOrder.getFavoriteOrder().toString());
            userDashboardConfigRepository.save(userConfig);

        }catch (Exception e){

            customResponse.setHttpStatusCode(HttpStatus.NOT_FOUND);
            customResponse.setError(Constants.ERRORCODE.DATANOTFOUND, Constants.ERRORMESSAGEID.DATANOTFOUND, Constants.ERRORMESSAGEEN.DATANOTFOUND);


        }
        //update/insert rate order by user id or corporate id


        //ge
        customResponse.setError(Constants.ERRORCODE.SUCCESS, Constants.ERRORMESSAGEID.SUCCESS, Constants.ERRORMESSAGEEN.SUCCESS);
        return customResponse;
    }

    public RateOrder listToString(List<RateOrderDto> rateOrderDto){
        int index =0;
        RateOrder rateOrder= new RateOrder();
        String rateOrderString="";
        String favoriteOrderString="";
        for (RateOrderDto rates: rateOrderDto) {
            if (index == 0){
                rateOrderString= rateOrderString.concat(rates.getCurrency());
                favoriteOrderString= favoriteOrderString.concat(rates.getFavorite());
            }else {
                rateOrderString = rateOrderString.concat(","+rates.getCurrency());

                favoriteOrderString = favoriteOrderString.concat(","+rates.getFavorite());
            }
            index++;

        }
        rateOrder.setRateOrder(rateOrderString);
        rateOrder.setFavoriteOrder(favoriteOrderString);
        System.out.println(rateOrder.getRateOrder());
        System.out.println(rateOrder.getFavoriteOrder());


        return rateOrder;
    }



    void checkRateOrder(){

    }
}
