package com.example.frescos.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ApplicationRol {
    AGENT("AGENT"),
    BUYER("BUYER");

    private final String code;
    public String getCode(){
        return this.code;
    }
    ApplicationRol(String code) {
        this.code = code;
    }

    public static ApplicationRol getApplicationRolFromString(String code){
        Optional<ApplicationRol> optRol = Arrays.stream(ApplicationRol.values()).filter(r->r.code.equals(code)).findFirst();
        return optRol.isPresent()? optRol.get():null;
    }
}
