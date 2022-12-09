package com.bootcamp.QATester.util;

import com.bootcamp.QATester.dto.req.TestCaseReqDto;
import com.bootcamp.QATester.dto.views.TestCaseResDto;
import com.bootcamp.QATester.entity.TestCase;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class Mapper {
    private static ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build();

    public static TestCase getTestCase(TestCaseReqDto testCaseReqDto){
        return mapper.convertValue(testCaseReqDto,TestCase.class);
    }
    public static TestCaseReqDto getTestCaseReqDto(TestCase testCase){
        return mapper.convertValue(testCase,TestCaseReqDto.class);
    }
    public static TestCaseResDto getTestCaseResDto(TestCase testCase){
        return mapper.convertValue(testCase,TestCaseResDto.class);
    }
}
