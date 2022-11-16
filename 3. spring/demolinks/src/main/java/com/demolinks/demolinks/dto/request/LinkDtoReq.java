package com.demolinks.demolinks.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LinkDtoReq {
    private Integer linkId;
    private String url;
}
