package com.bootcamp.CarAgency.entity;

import lombok.Data;

@Data
public class Service {
    private Integer id=0;
    private String date;
    private String kilometers;
    private String descriptions;

    public Service() {
        this.id += 1;
    }

}
