package com.bootcamp.joyeria.dto.view;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GemView {
    private Long id;
    private String name;
    private String material;
    private String weight;
    private String particularity;
    private Boolean ownsRock;
    private Boolean saleOrNot;
}
