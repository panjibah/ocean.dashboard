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

    public InquiryEratesResponse inquiryEratesByUserConfigResponse(String xClient, String xToken){

        InquiryEratesResponse customResponse = new InquiryEratesResponse();
        InquiryEratesOutputSchema outputSchema = null;
        String rateConstant = "USD,SGD,HKD,AUD,GBP,EUR,CNY,JPY";
        //get latest inquiry erates
        //get user config
        //sort erates using user config
        //add favoites value
        //create hashmap<string, erates> string key is currency name, it will used to store currency for faster retreival
        //sort
        //return erates


        try {
            List<Erate> optionalErate = erateRepository.findLatestDataForEachCurrency();
            Optional<UserConfig> optionalUserDashboardConfig =  userDashboardConfigRepository.findByUserIdAndCorporateId("2","2");
            List<Erate> listRateOrder = sortEratesByUserConfig(optionalErate,optionalUserDashboardConfig.get());
            List<EratesDto> listRateDto = addFavoriteValue(listRateOrder,getCurrenciesInOrder(rateConstant));
            System.out.println(listRateOrder.toString());

            String updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            outputSchema = new InquiryEratesOutputSchema(listRateDto,updateDate);
            customResponse.setOutputSchema(outputSchema);
            customResponse.setHttpStatusCode(HttpStatus.FOUND);
            customResponse.setError(Constants.ERRORCODE.SUCCESS, Constants.ERRORMESSAGEID.SUCCESS, Constants.ERRORMESSAGEEN.SUCCESS);


        }catch (Exception e){

        }

        return customResponse;
    }

    public InquiryEratesResponse inquiryErates(String xClient, String xToken){
        InquiryEratesResponse customResponse = new InquiryEratesResponse();

        return customResponse;
    }


    public List<Erate> sortEratesByUserConfig(List<Erate> erate, UserConfig userConfig){
        Map<String, Erate> exchangeRateMap = new HashMap<>();
        List<Erate> orderedExchangeRates = new ArrayList<>();
        try {
            //create hashmap
            for(Erate rate: erate){
                exchangeRateMap.put(rate.getCurrency(),rate);
            }
            //order

            for (String currency : getCurrenciesInOrder(userConfig.getRateOrder())) {
                Erate rate = exchangeRateMap.get(currency);
                if (rate != null) {

                    orderedExchangeRates.add(rate);
                }
            }


      }catch (Exception e){

      }
        return orderedExchangeRates;

    }

    public List<EratesDto> addFavoriteValue(List<Erate> erate, List<String> defaultRate){
        List<EratesDto> eratesDtos = new ArrayList<>();
        EratesDto eratesDto = new EratesDto();
        int diff = 0;
        //System.out.println("xxx size erate"+erate.size());
        try {
            for (int i =0 ;i<=erate.size();i++){
                //System.out.println("+++++" + erate.get(i).getCurrency() + "[]" +defaultRate.get(i)+"[]");
                //System.out.println("+++++" +  erate.get(i).getCurrency().getClass() + "[]" +defaultRate.get(i)+"[]");
                if(!erate.get(i).getCurrency().toString().equals(defaultRate.get(i).toString())){
                    eratesDto = modelMapper().map(erate.get(i), EratesDto.class);
                    eratesDto.setFavorite("1");
                   diff=diff+1;

                }
                else {
                    eratesDto = modelMapper().map(erate.get(i), EratesDto.class);
                    System.out.println("not favorite" + erate.get(i).getCurrency());
                    eratesDto.setFavorite("0");
                }
                eratesDtos.add(eratesDto);
            }




        }catch (Exception e){

        }
        System.out.println(diff);
        if(diff > 0 ){
            System.out.println("asdadasdasdadasd");
            eratesDtos.get(0).setFavorite("1");
        }

        return eratesDtos;

    }

    private List<String> getCurrenciesInOrder(String rateOrder) {
        String[] ArrayRateOrder= rateOrder.split(",");
        List<String> listRateOrder= Arrays.asList(ArrayRateOrder);
        System.out.println("--------"+listRateOrder);
        return listRateOrder;
    }
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
