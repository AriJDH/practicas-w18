package ejercicioIntegradorP1PG.Turismo.Model;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    RepositorioLocalizadorImpl repo = new RepositorioLocalizadorImpl();

    public Localizador(Cliente cliente, List<Paquete> paquetes) {
        super();
        this.cliente = cliente;
        this.paquetes = paquetes;
    }

    private Cliente cliente;

    private double total;

    private List<Paquete> paquetes = new ArrayList<>();

    public void calcularTotal() {

        int cantidadLocalizadores = repo.descuentoPorCliente(getCliente());
        if (cantidadLocalizadores >= 2) {
            System.out.println("----*********------- \nEn proxima compra se le descontara un %5");
        }

        for (Paquete p : getPaquetes()) {

            if (p.esCompleto())
                System.out.println(
                        "----*********------- \nEn este paquete: " + p.toString() + " tienes " + "%10 de descuento");

        }

        if(getPaquetes().stream().filter(p -> p.isHotel()).count() >= 2) {
            System.out.println(
                    "----*********------- \nEn este paquete: tenes %5 de descuento por tener 2 hoteles o mas" );
        }else if(getPaquetes().stream().filter(p -> p.isBoleto()).count() >= 2) {
            System.out.println(
                    "----*********------- \nEn este paquete: tenes %5 de descuento por tener 2 boletos o mas" );
        }


    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Localizador [cliente=" + cliente.toString() + ", total=" + getTotal() + ", paquetes=" + paquetes + "]";
    }
}
