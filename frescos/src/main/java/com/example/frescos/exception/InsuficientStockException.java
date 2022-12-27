package com.example.frescos.exception;

import java.util.List;

public class InsuficientStockException extends RuntimeException{
    public InsuficientStockException(String message){
        super(message);
    }
}
