package ejemplo_patron_decorator.clases;

import ejemplo_patron_decorator.interfaces.Vehiculo;

public class VehiculoBase implements Vehiculo {

    private Double precioBase;

    private String modelo;

    private String accesoriosEstandar;

    public VehiculoBase(Double precioBase, String modelo, String accesoriosEstandar) {
        this.precioBase = precioBase;
        this.modelo = modelo;
        this.accesoriosEstandar = accesoriosEstandar;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAccesoriosEstandar() {
        return accesoriosEstandar;
    }

    public void setAccesoriosEstandar(String accesoriosEstandar) {
        this.accesoriosEstandar = accesoriosEstandar;
    }

    @Override
    public Double obtenerPrecio() {
        return getPrecioBase();
    }

    @Override
    public String obtenerAccesorios() {
        return getAccesoriosEstandar();
    }
}
