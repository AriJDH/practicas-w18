import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        int cantHotel = 0;
        int cantViaje = 0;
        int cantLocalizadores = 0;
        int paquetesCompletos = 0;

        //Resolución de los items del enunciado - Parte 1

        Cliente c1 = new Cliente("Juan", "Perez", "32.123.432");
        List<String> reservas = new ArrayList<String>();
        reservas.add("Hotel");
        reservas.add("Comida");
        reservas.add("Viaje");
        reservas.add("Transporte");
        cantHotel++;
        cantViaje++;
        paquetesCompletos++;
        cantLocalizadores++;

        c1.setCantHotel(cantHotel);
        c1.setCantViaje(cantViaje);
        c1.setPaquetesCompletos(paquetesCompletos);
        c1.setCantLocalizadores(cantLocalizadores);

        Localizador l1 = new Localizador(2000,reservas,c1);

        System.out.println("El resultado de la compra fue: ");
        System.out.println("Precio de la compra: " + l1.getTotal());
        System.out.println("Reservas: " + reservas);
        System.out.println("Cliente que realizo la compra: " + "\n" +  c1);

        if(c1.getPaquetesCompletos() > 0) {
            double precioConDescuento = 0;
            precioConDescuento = l1.getTotal() - (l1.getTotal()*0.10);
            System.out.println("El cliente " + c1.getNombre() + ", adquirio un paquete completo por lo tanto se le aplica un descuento del 10% sobre el total de su compra.");
            System.out.println("El descuento es de: " + l1.getTotal()*0.10);
            System.out.println("El precio final a abonar es de: " + precioConDescuento);
        }

        if(c1.getCantLocalizadores() >= 2) {
            System.out.println("El cliente " + c1.getNombre() + ", adquirio " + c1.getCantLocalizadores() + " localizadores. Por lo tanto se le aplica un descuento del 5% para futuras compras");
        }

        if(c1.getCantHotel() >= 2 || c1.getCantViaje() >= 2) {
            System.out.println("El cliente " + c1.getNombre() + ", adquirio 2 o mas reservas de hotel o de viajes. Le corresponde un descuento de 5% en esas reservas.");
        }






    }

}
