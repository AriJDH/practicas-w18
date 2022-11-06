package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Integer id;
    private List<Localizador>localizadors=new ArrayList<>();

    public Cliente(Integer id, List<Localizador> localizadors) {
        this.id = id;
        this.localizadors = localizadors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Localizador> getLocalizadors() {
        return localizadors;
    }

    public void setLocalizadors(List<Localizador> localizadors) {
        this.localizadors = localizadors;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", localizadors=" + localizadors +
                '}';
    }
}
