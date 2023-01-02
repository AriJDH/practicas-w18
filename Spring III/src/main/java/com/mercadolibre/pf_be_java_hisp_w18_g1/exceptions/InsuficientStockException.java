package com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions;

import java.util.List;

public class InsuficientStockException extends RuntimeException{
    public InsuficientStockException(String message){
        super(message);
    }
}
