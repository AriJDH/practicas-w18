package com.example.linktracker.entities;

import com.example.linktracker.exceptions.IncorrectPasswordException;
import com.example.linktracker.exceptions.InvalidUrlException;
import com.example.linktracker.exceptions.InvalidatedLinkException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;

@NoArgsConstructor
public class Link {
    private long id;
    private String link;
    private String password;
    private int redirectionCount = 0;
    private boolean invalidated = false;

    public Link(long id, String link, String password) {
        UrlValidator urlValidator = new UrlValidator();
        if(!urlValidator.isValid(link))
            throw new InvalidUrlException("El URL ingresado es inválido");
        this.id = id;
        this.link = link;
        this.password = password;
    }

    public boolean hasPassword(){
        return this.password!=null;
    }

    public void addRedirection(){
        this.redirectionCount++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLink(String password) {
        if(this.invalidated)
            throw new InvalidatedLinkException("Está tratando de acceder a un link invalidado");
        if(this.hasPassword() && !this.password.equals(password))
            if(password==null)
                throw new IncorrectPasswordException("El link requiere contraseña");
            else
                throw new IncorrectPasswordException("La contraseña ingresada es incorrecta");
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRedirectionCount() {
        return redirectionCount;
    }

    public void setRedirectionCount(int redirectionCount) {
        this.redirectionCount = redirectionCount;
    }

    public boolean isInvalidated() {
        return invalidated;
    }

    public void setInvalidated(boolean invalidated) {
        this.invalidated = invalidated;
    }
}
