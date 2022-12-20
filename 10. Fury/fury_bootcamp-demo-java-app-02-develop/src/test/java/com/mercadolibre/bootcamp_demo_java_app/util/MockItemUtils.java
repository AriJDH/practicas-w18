package com.mercadolibre.bootcamp_demo_java_app.util;

import java.io.IOException;
import java.net.URISyntaxException;

import com.mercadolibre.restclient.MockResponse;
import com.mercadolibre.restclient.http.ContentType;
import com.mercadolibre.restclient.http.HttpMethod;

public class MockItemUtils {
	public static void mockItemRequest(String itemId) throws URISyntaxException, IOException {
		byte[] jsonContents = JsonReadUtils.getJsonContent("item_info_" + itemId + ".json");
		MockResponse.builder().withURL("http://fake.api.mercadolibre.com/items/MLU467183322").withMethod(HttpMethod.GET)
				.withStatusCode(200)
				.withResponseHeader(ContentType.HEADER_NAME, ContentType.APPLICATION_JSON.toString())
				.withResponseBody(jsonContents).build();
	}
}
