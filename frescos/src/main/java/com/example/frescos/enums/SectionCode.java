package com.example.frescos.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SectionCode {
    FRESH(0),
    COOL(1),
    FROZEN(2);

    SectionCode(Integer code) {
        this.code = code;
    }

    private final Integer code;
    public static SectionCode sectionCodeFromInteger(Integer i){
        Optional<SectionCode> optSectionCode = Arrays.stream(SectionCode.values()).filter(s->s.code.equals(i)).findFirst();
        return optSectionCode.isPresent()?optSectionCode.get():null;
    }

}
