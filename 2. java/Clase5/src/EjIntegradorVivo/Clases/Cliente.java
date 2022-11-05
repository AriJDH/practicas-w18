package EjIntegradorVivo.Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Localizador> localizadores;
    private Long id;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }

    public String getNombre() {
        return nombre;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "Cliente{" +
//                "nombre='" + nombre + '\'' +
//                ", cantReservas=" + cantReservas +
//                ", id=" + id +
//                '}';
//    }
}
