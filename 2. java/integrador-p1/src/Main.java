import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Cliente alice = new Cliente(1, "20203030", "Alice", "Test");
        Cliente bob = new Cliente(2, "30302010", "Bob", "Foo");

        ReservaHotel hotel1 = new ReservaHotel("Seasons", 3000);
        ReservaHotel hotel2 = new ReservaHotel("Panamericano", 1000);

        ReservaComida comida1 = new ReservaComida("Restaurant italiano", 15);
        ReservaComida comida2 = new ReservaComida("Tacos", 5);

        ReservaBoleto boleto1 = new ReservaBoleto("Delta airlines", 300);
        ReservaBoleto boleto2 = new ReservaBoleto("Jet Viajes", 140);

        ReservaTransporte transporte1 = new ReservaTransporte("taxi 5km", 10);
        ReservaTransporte transporte2 = new ReservaTransporte("micro 10km", 8);

        List<Reserva> paquete1 = Arrays.asList(hotel1, comida2, boleto1, transporte2);

        Localizador localizador1 = new Localizador(alice, paquete1);

//        System.out.println(alice);
//        System.out.println(hotel1);
//        System.out.println(paquete1);
        System.out.println(localizador1);

    }
}