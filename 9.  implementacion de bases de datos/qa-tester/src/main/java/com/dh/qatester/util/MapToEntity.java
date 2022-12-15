package com.dh.qatester.util;

import com.dh.qatester.dto.TestCaseDtoReq;
import com.dh.qatester.entity.TestCase;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class MapToEntity {

    private static ModelMapper mapper;

    private static ModelMapper instance(){
        if (mapper == null){
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static TestCase map(TestCaseDtoReq testCaseDto) {
        TestCase result = instance().map(testCaseDto, TestCase.class);
        LocalDate date = HandlerDate.StringToDate(strDate);
        return null;
    }


}
