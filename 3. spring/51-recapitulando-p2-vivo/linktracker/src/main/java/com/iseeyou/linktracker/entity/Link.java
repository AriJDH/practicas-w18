package com.iseeyou.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    private Integer linkId;
    private String url;
    private Integer contador;
    private String password;
}
