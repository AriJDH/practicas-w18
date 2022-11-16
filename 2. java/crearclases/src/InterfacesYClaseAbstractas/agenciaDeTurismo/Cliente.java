package InterfacesYClaseAbstractas.agenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private long dni;
    private String nombre;
    List<Localizador> localizadores = new ArrayList<>();

    public Cliente(long dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public String toString() {
        return  "dni=" + dni +
                " nombre='" + nombre + '\'' +
                " localizadores=" + localizadores;
    }
}
