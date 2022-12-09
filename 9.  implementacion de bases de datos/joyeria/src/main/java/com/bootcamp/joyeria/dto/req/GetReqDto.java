package com.bootcamp.joyeria.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReqDto {
    private String name;
    private String material;
    private String weight;
    private String particularity;
    private Boolean ownsRock;
    private Boolean saleOrNot;
}
