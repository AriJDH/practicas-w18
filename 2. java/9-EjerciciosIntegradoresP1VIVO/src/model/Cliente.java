package model;

import java.util.List;

public class Cliente {

    // Atributos
    private Long id;
    private List<Localizador> localizadores;

    // Constructores
    public Cliente() {
    }

    public Cliente(Long id, List<Localizador> localizadores) {
        this.id = id;
        this.localizadores = localizadores;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }


    // Métodos
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", localizadores=" + localizadores +
                '}';
    }
}
