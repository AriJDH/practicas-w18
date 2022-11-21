package com.playground.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer kilometers;
    private String descriptions;

}
