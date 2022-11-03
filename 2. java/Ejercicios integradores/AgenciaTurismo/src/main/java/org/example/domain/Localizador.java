package org.example.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double totalPostDescuento;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = this.calcularTotalDeReservas();
        double descuento = CalculadorDescuentos.instancia().calcularDescuentos(this);
        this.totalPostDescuento=this.total - descuento;
        this.cliente.addLocalizador(this);
    }

    public double calcularTotalDeReservas(){
        return this.reservas.stream().mapToDouble(r->r.getPrecio()).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean esPaqueteCompleto(){
        List<TipoReserva> tipos = this.reservas.stream().map(reserva-> reserva.getTipoReserva()).collect(Collectors.toList());
        return Arrays.stream(TipoReserva.values()).allMatch(tipoReserva-> tipos.contains(tipoReserva));
    }

    public long cantidadDeReservasPorTipo(TipoReserva tipoReserva){
        return this.reservas.stream().filter(r->r.getTipoReserva().equals(tipoReserva)).count();
    }

    @Override
    public String toString(){
        String s =   "Localizador de " + this.cliente.getNombreCompleto() + ". Precio total: "
                + this.total + ". Precio total post descuentos: " + this.totalPostDescuento +"."
                +"\nFormado por las reservas: ";
        for(Reserva reserva : reservas){
            s+="\n-"+reserva.toString();
        }
        return s;
    }
}
