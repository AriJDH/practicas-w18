package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService) {
		this.itemsApiService = itemsApiService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		Double itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo;
	}

	public ResponseEntity<?> getItemPriceUSD(String itemId) throws ParseException, RestException {
		CurrencyDTO itemInfo = itemsApiService.getItemInfoCurrency(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return new ResponseEntity<>(itemInfo, HttpStatus.OK);
	}


}
