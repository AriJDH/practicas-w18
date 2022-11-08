import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente(new ArrayList<>(),1, "Gabriel");
        Reserva hotel1 = new Hotel(15000,"Hilton", "2022-12-01", "2022-12-15");
        Reserva comida1 = new Comida(1000,"Milanesa", "2022-12-11", "2022-12-11");
        Reserva boleto1 = new Boleto(1000,"Taxi", "2022-12-01", "2022-12-01");
        Reserva transporte1 = new Transporte(30000,"Avion", "2022-12-01", "2022-12-15");
        Localizador l1 = new Localizador();
        l1.agregarReserva(hotel1);
        l1.agregarReserva(comida1);
        l1.agregarReserva(boleto1);
        l1.agregarReserva(transporte1);
        c1.agregarLocalizador(l1);
        Localizador l2 = new Localizador();
        l2.agregarReserva(hotel1);
        l2.agregarReserva(comida1);
        l2.agregarReserva(boleto1);
        l2.agregarReserva(boleto1);
        l2.agregarReserva(transporte1);
        l2.agregarReserva(transporte1);
        c1.agregarLocalizador(l2);
        Localizador l3 = new Localizador();
        l3.agregarReserva(boleto1);
        l3.agregarReserva(transporte1);
        l3.agregarReserva(transporte1);
        c1.agregarLocalizador(l3);



        System.out.println(c1);
//        if (c1.descuento()){
//
//        }


    }
}
