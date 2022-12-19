package com.mercadolibre.bootcamp_demo_java_app.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercadolibre.bootcamp_demo_java_app.util.MockItemUtils;

class ItemPriceControllerTest extends ControllerTest {

	@Test
	void itemPrice() throws URISyntaxException, IOException {
		String itemId = "MLU467183322";
		MockItemUtils.mockItemRequest(itemId);
		Double expectedPrice = Double.valueOf("395");

		//curl http://localhost:8080/prices/MLU467183322
		ResponseEntity<Double> responseEntity = this.testRestTemplate.exchange("/prices/MLU467183322", HttpMethod.GET, this.getDefaultRequestEntity(), Double.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(expectedPrice, responseEntity.getBody());
	}
}
