package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorUserNotFoundDTOres extends ErrorDTOres{
    public ErrorUserNotFoundDTOres(int code, String message, int user_id_not_found) {
        super(code, message);
        this.user_id_not_found = user_id_not_found;
    }

    private int user_id_not_found;
}
