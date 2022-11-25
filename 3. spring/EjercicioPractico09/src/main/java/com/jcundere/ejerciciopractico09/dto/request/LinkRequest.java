package com.jcundere.ejerciciopractico09.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LinkRequest {

    private String url;
    private String password;

}
