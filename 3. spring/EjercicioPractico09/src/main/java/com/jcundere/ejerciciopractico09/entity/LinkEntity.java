package com.jcundere.ejerciciopractico09.entity;

import com.jcundere.ejerciciopractico09.exception.InvalidUrlException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkEntity {

    private Integer id;
    private String url;
    private String password;
    private Integer visited;
    private Boolean isValid;

    public LinkEntity(Integer id, String url, String password) {

        this.id = id;
        this.url = url;
        this.password = password;
        this.visited = 0;
        this.isValid = Boolean.TRUE;

    }

    public String getUrl() {

        if (!this.isValid){

            throw new InvalidUrlException("Link Invalido !");
        } else {
            return url;
        }
    }

    public void redirectionSuccess(){
        this.visited++;
    }

}
