package com.mercadolibre.bootcamp_demo_java_app.api.services;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsApiService extends RestClientService{
    @Value("${meli.base.url}")
    private String baseUrl;

    private String itemsApiBaseUrl;
    
    private RestClient itemsApiClient;

    public ItemsApiService() throws IOException{
    	super();
    }
    
    @PostConstruct
    public void init() throws IOException {
        itemsApiBaseUrl = String.format("%s/items/",baseUrl);
        itemsApiClient = RestClient.builder()
        	    .withPool(restPool)
        	    .build();
    }

    public Double getItemInfo(String itemId) throws ParseException, RestException{
        String currentItemUrl = itemsApiBaseUrl + itemId;
        Response resp = itemsApiClient.get(currentItemUrl);
        ItemDTO item = resp.getData(ItemDTO.class);
        CurrencyDTO resp2 = getItemInfoCurrency(String.valueOf(item.getCurrencyId()));
        Double usdValue = item.getPrice() * (resp2.getRatio() / resp2.getInvRate()) ;
        return usdValue;
    }

    public CurrencyDTO getItemInfoCurrency(String currencyId) throws ParseException, RestException{
        String currentItemUrl = baseUrl + "/currency_conversions/search?from="+ currencyId +"&to=USD";
        Response resp = itemsApiClient.get(currentItemUrl);
        return resp.getData(CurrencyDTO.class);
    }
}
