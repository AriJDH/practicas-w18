package com.example.qatesters.util.mapper;

import com.example.qatesters.dto.request.TestCaseRequest;
import com.example.qatesters.dto.response.TestCaseResponse;
import com.example.qatesters.entity.TestCaseEntity;

import java.util.ArrayList;
import java.util.List;

public class TestCaseMapper {

    public static TestCaseEntity request2entity(TestCaseRequest request) {

        TestCaseEntity entity = new TestCaseEntity();

        entity.setDescription(request.getDescription());
        entity.setTested(request.getTested());
        entity.setPassed(request.getPassed());
        entity.setNumberOfTries(request.getNumberOfTries());
        entity.setLastUpdate(request.getLastUpdate());

        return entity;
    }

    public static TestCaseResponse entity2Response(TestCaseEntity entity) {

        TestCaseResponse response = new TestCaseResponse();
        response.setDescription(entity.getDescription());
        response.setTested(entity.getTested());
        response.setPassed(entity.getPassed());
        response.setNumberOfTries(entity.getNumberOfTries());
        response.setLastUpdate(entity.getLastUpdate());

        return response;
    }

    public static List<TestCaseResponse> entityList2ResponseList(List<TestCaseEntity> entityList) {

        List<TestCaseResponse> responseList = new ArrayList<>();
        for (TestCaseEntity entity : entityList) {
            responseList.add(entity2Response(entity));
        }

        return responseList;
    }

}
