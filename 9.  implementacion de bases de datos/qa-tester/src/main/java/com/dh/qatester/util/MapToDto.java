package com.dh.qatester.util;

import com.dh.qatester.dto.TestCaseDtoRes;
import com.dh.qatester.entity.TestCase;
import org.modelmapper.ModelMapper;

public class MapToDto {
    private static ModelMapper mapper;
    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static TestCaseDtoRes map(TestCase testCase){
        return instance().map(testCase, TestCaseDtoRes.class);
    }



}
