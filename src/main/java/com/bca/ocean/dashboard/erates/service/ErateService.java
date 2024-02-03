package com.bca.ocean.dashboard.erates.service;

import com.bca.ocean.dashboard.erates.model.dto.EratesDto;
import com.bca.ocean.dashboard.erates.model.dto.UserConfigDto;
import com.bca.ocean.dashboard.erates.model.entity.Erate;
import com.bca.ocean.dashboard.erates.model.entity.UserConfig;
import com.bca.ocean.dashboard.erates.model.io.response.erates.InquiryEratesOutputSchema;
import com.bca.ocean.dashboard.erates.model.io.response.erates.InquiryEratesResponse;
import com.bca.ocean.dashboard.erates.repository.ErateRepository;
import com.bca.ocean.dashboard.erates.repository.UserDashboardConfigRepository;
import com.bca.ocean.dashboard.erates.util.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErateService {
    @Autowired
    ErateRepository erateRepository;
    @Autowired
    UserDashboardConfigRepository userDashboardConfigRepository;

    public InquiryEratesResponse inquiryEratesByUserConfigResponse(String xClient, String xToken) {

        InquiryEratesResponse customResponse = new InquiryEratesResponse();
        InquiryEratesOutputSchema outputSchema = null;
        List<Erate> listRateOrder  = new ArrayList<>();
        List<EratesDto> listRateDto= new ArrayList<>();
        String rateConstant = "USD,SGD,HKD,AUD,GBP,EUR,CNY,JPY";
        String favoriteConstant= "0,0,0,0,0,0,0,0";
        //get latest inquiry erates
        //get user config
        //sort erates using user config
        //add favoites value
        //create hashmap<string, erates> string key is currency name, it will used to store currency for faster retreival
        //sort
        //return erates


        try {
            List<Erate> optionalErate = erateRepository.findLatestDataForEachCurrency();
            Optional<UserConfig> optionalUserDashboardConfig = userDashboardConfigRepository.findByUserIdAndCorporateId("2", "2");
            if (optionalUserDashboardConfig.isPresent()) {
                listRateOrder = sortEratesByUserConfig(optionalErate, optionalUserDashboardConfig.get().getRateOrder());
                listRateDto = addFavoriteValue(listRateOrder, stringToList(optionalUserDashboardConfig.get().getFavorite()));
                System.out.println(listRateOrder.toString());
            }else {
                listRateOrder = sortEratesByUserConfig(optionalErate, rateConstant);
                listRateDto = addFavoriteValue(listRateOrder, stringToList(rateConstant));

            }


            String updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            outputSchema = new InquiryEratesOutputSchema(listRateDto, updateDate);
            customResponse.setOutputSchema(outputSchema);
            customResponse.setHttpStatusCode(HttpStatus.OK);
            customResponse.setError(Constants.ERRORCODE.SUCCESS, Constants.ERRORMESSAGEID.SUCCESS, Constants.ERRORMESSAGEEN.SUCCESS);


        } catch (Exception e) {
            System.out.println(e);

        }

        return customResponse;
    }

    public InquiryEratesResponse inquiryErates(String xClient, String xToken) {
        InquiryEratesResponse customResponse = new InquiryEratesResponse();

        return customResponse;
    }


    public List<Erate> sortEratesByUserConfig(List<Erate> erate, String userConfig) {
        Map<String, Erate> exchangeRateMap = new HashMap<>();
        List<Erate> orderedExchangeRates = new ArrayList<>();
        try {
            //create hashmap
            for (Erate rate : erate) {
                exchangeRateMap.put(rate.getCurrency(), rate);
            }
            //order

            for (String currency : stringToList(userConfig)) {
                Erate rate = exchangeRateMap.get(currency);
                if (rate != null) {

                    orderedExchangeRates.add(rate);
                }
            }


        } catch (Exception e) {

        }
        return orderedExchangeRates;

    }

    public List<EratesDto> addFavoriteValue(List<Erate> erate, List<String> favoriteOrder) {
        List<EratesDto> eratesDtos = new ArrayList<>();
        EratesDto eratesDto = new EratesDto();
        try {
            for (int i = 0; i <= erate.size(); i++) {

                eratesDto = modelMapper().map(erate.get(i), EratesDto.class);
                eratesDto.setFavorite(favoriteOrder.get(i));
                eratesDtos.add(eratesDto);
            }
        } catch (Exception e) {

        }
        return eratesDtos;

    }

    private List<String> stringToList(String rateOrder) {
        String[] arrayOrder = rateOrder.split(",");
        List<String> listOfString = Arrays.asList(arrayOrder);

        return listOfString;
    }

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
