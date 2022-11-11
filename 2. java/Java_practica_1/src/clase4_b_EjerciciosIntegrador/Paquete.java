package clase4_b_EjerciciosIntegrador;

import javax.swing.tree.TreeNode;
import java.util.List;

public class Paquete extends Reserva{
    public Paquete() {
        super(0.0, "Paquete");
    }
    private List<Comida> comida;
    private List<Hotel> hotel;
    private List<BoletosDeViaje> boleto;
    private List<Transporte> transporte;

    public List<Comida> getComida() {
        return comida;
    }

    public void setComida(List<Comida> comida) {
        this.comida = comida;
    }

    public void addComida(Comida comida){
        this.comida.add(comida);
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void addHotel(Hotel hotel){
        this.hotel.add(hotel);
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public void addBoleto(BoletosDeViaje boleto){
        this.boleto.add(boleto);
    }

    public List<BoletosDeViaje> getBoleto() {
        return boleto;
    }

    public void setBoleto(List<BoletosDeViaje> boleto) {
        this.boleto = boleto;
    }

    public void addTransporte(Transporte transporte){
        this.transporte.add(transporte);
    }
    public List<Transporte> getTransporte() {
        return transporte;
    }

    public void setTransporte(List<Transporte> transporte) {
        this.transporte = transporte;
    }

    public boolean esPaqueteCompleto(){
        return !(this.transporte.isEmpty() || this.boleto.isEmpty() || this.hotel.isEmpty() || this.comida.isEmpty());
    }

    public Double getPrecio() {
        double precio = this.transporte.stream().mapToDouble(x->x.getPrecio()).sum() +
                        this.boleto.stream().mapToDouble(x->getPrecio()).sum() +
                        this.hotel.stream().mapToDouble(x->getPrecio()).sum() +
                        this.comida.stream().mapToDouble(x-> getPrecio()).sum() ;
        if (esPaqueteCompleto()) precio *= 0.9;
        return precio;
    }
}
