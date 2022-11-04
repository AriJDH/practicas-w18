import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio implements Localizador{
    Cliente cliente;
    List<PaqueteTuristico> paquetes;
    int descuento;

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Repositorio(Cliente cliente, List<PaqueteTuristico> paquetes) {
        this.cliente = cliente;
        this.paquetes = paquetes;
    }

    public Repositorio(){

    }
    public Repositorio(Cliente cliente) {
        this.cliente = cliente;
        this.paquetes = new ArrayList<PaqueteTuristico>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<PaqueteTuristico> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public void guardarReserva( PaqueteTuristico paq) {
        this.paquetes.add(paq);
    }

    @Override
    public void mostrarReserva(PaqueteTuristico paquete, Cliente cliente) {
        calcularPrecio(paquete);
        System.out.println("El cliente: " + cliente.toString() +" reservò los sigueintes paquetes:");
        System.out.println(paquete.toString());

        System.out.println("Precio total: $" + precioTotal(paquete));

    }

    public double calcularDescuento (){
        double dco = 0;
        int hotel= 0;
        int pasajes=0;
       if(!this.paquetes.isEmpty()){
           if(this.paquetes.size()>=2)
               dco=5;

           for(PaqueteTuristico p:this.paquetes){
               if(p.completo)
                   dco=10;
               if(p.hotel)
                   hotel++;
               if(p.pasaje)
                   pasajes++;
           }

           if(hotel>1 || pasajes<1)
               this.descuento=5;
       }

        return dco;
    }


    public void calcularPrecio(PaqueteTuristico p){
        p.precio = 34000;
        if (p.completo)
            p.precio= 50000;
        if(p.hotel && p.pasaje)
            p.precio= 22000;
        if(p.hotel && p.comida)
            p.precio = 14000;

    }

    public double precioTotal(PaqueteTuristico p){
        if(this.descuento >0)
            return p.precio*this.descuento/100;
        else  return p.precio;
    }


}
