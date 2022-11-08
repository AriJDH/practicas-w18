package practica_agencia_turismo.clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;

    private String identificacion;

    private List<Localizador> localizadores;

    private Boolean descuento5Porciento;

    public Cliente() {

        this.localizadores = new ArrayList<>();
        descuento5Porciento = Boolean.FALSE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public Boolean getDescuento5Porciento() {
        return descuento5Porciento;
    }

    public void setDescuento5Porciento(Boolean descuento5Porciento) {
        this.descuento5Porciento = descuento5Porciento;
    }

    public void crearLocalizador(Localizador localizador) {

        if (this.localizadores.size() >= 2) {
            this.descuento5Porciento = Boolean.TRUE;
        }

        localizador.calcularPaqueteCompleto();

        if (this.descuento5Porciento) {
            localizador.aplicar5Porciento();
        }

        localizador.aplicarDescuentoReservaHotelViaje();

        this.localizadores.add(localizador);

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", localizadores=" + localizadores +
                '}';
    }
}
