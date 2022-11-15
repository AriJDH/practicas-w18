package com.meli.recapitulandospringp2vivo.dto.request;

import lombok.Getter;

@Getter
public class CreateLinkDTO {
    private String link;
    private String password;

    @Override
    public String toString() {
        return "CreateLinkDTO{" +
                "link='" + link + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
