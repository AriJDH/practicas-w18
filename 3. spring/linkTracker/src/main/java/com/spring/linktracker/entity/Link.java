package com.spring.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private String url;
    private Long id;
    private Integer redirectCount;
    private Boolean isValid;

    public void addRedirectCount(){
        this.redirectCount++;
    }
}


