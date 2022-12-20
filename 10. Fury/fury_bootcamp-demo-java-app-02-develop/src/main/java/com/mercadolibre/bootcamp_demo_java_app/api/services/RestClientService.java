package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.restclient.RESTPool;

public abstract class RestClientService {
    protected RESTPool restPool;
    
    public RestClientService() {
    	restPool = RESTPool.builder()
                .withName("rest_pool")
                .build();
    }    
}
