package com.mercadolibre.Redirect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {
    private Integer id;
    private String url;
    private String password;
    private boolean invalidating;
    private int count;

    public Link(Integer id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
    }
}
