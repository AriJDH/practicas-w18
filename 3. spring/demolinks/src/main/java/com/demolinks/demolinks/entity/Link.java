package com.demolinks.demolinks.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class Link {
    private Integer linkId;
    private String url;
    private Integer contador;
    private String password;


}
