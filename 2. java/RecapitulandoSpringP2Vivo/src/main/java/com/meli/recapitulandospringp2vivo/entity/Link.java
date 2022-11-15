package com.meli.recapitulandospringp2vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Link {
    private Integer id;
    private String link;
    private String password;
    private Integer count;

    public Link(String link, String password) {
        this.link = link;
        this.password = password;
        this.count = 0;
    }

    public void increaseView(){
        count++;
    }

}
