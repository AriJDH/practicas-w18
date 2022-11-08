import model.Cliente;
import model.Factura;
import model.Reserva;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Reserva reserva1 = new Reserva(1, "Hotel",45000.0);
        Reserva reserva2 = new Reserva(2, "Hotel",50000.0);
        ArrayList<Reserva> listaDeReservas= new ArrayList<>();
        listaDeReservas.add(reserva1);
        //listaDeReservas.add(reserva2);
        Factura factura1 = new Factura(listaDeReservas);
        Factura factura2 = new Factura(listaDeReservas);
        ArrayList<Factura> listaDeFacturas= new ArrayList<>();
        listaDeFacturas.add(factura1);
        listaDeFacturas.add(factura2);
        Cliente cliente1= new Cliente(listaDeFacturas, "Pepe", "Perez", "12343");

        System.out.println("Precio sin aplicar los descuentos: ");
        for(Factura facturas : cliente1.getFacturas()){
            for(Reserva reservas : facturas.getReservas()){
                System.out.println(reservas.getPrecio());
            }
        }


        //Si tiene 2 o mas facturas acumuladas se aplica un descuente del 5% a cada una de sus reservas
        if(cliente1.facturasAcumuladas()>=2){
            for(Factura facturas : cliente1.getFacturas()){
                for(Reserva reservas : facturas.getReservas()){
                    reservas.setPrecio(reservas.getPrecio()-(reservas.getPrecio()*0.05));
                }
            }
        }

        System.out.println("Precio con descuentos aplicados: ");
        for(Factura facturas : cliente1.getFacturas()){
            for(Reserva reservas : facturas.getReservas()){
                System.out.println(reservas.getPrecio());
            }
        }

    }
}
