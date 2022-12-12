package com.jpaHibernate.testerQA.util;

import com.jpaHibernate.testerQA.dto.TestCaseDTO;
import com.jpaHibernate.testerQA.model.TestCase;
import org.modelmapper.ModelMapper;

public class MapTo {

    private static ModelMapper mapper;
    private static ModelMapper instance(){
        if(mapper == null){
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static TestCaseDTO entityToDTO(TestCase testCase){
        return instance().map(testCase, TestCaseDTO.class);
    }

    public static TestCase dtoToEntity(TestCaseDTO testCaseDTO){
        return instance().map(testCaseDTO, TestCase.class);
    }




/*    public static TestCaseDTO entityToDto(TestCase testCase){
        TestCaseDTO testCaseDTO = new TestCaseDTO();
        return testCaseDTO;
    }*/
}
