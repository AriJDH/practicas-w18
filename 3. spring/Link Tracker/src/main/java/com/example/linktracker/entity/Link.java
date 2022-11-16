package com.example.linktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Link {
    private String link;
    private String password;
    private Integer count;
    private Boolean isValid;

    public Link(String link, int i, boolean b) {
    }
}
