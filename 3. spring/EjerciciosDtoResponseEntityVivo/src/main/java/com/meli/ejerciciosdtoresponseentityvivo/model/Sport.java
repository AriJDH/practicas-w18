package com.meli.ejerciciosdtoresponseentityvivo.model;

import java.io.Serializable;

public class Sport {
    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
