package EjIntegradorVivo;
import EjIntegradorVivo.Clases.*;
import EjIntegradorVivo.Repositorio.RepositorioCliente;
import EjIntegradorVivo.Repositorio.RepositorioLocalizador;
import java.util.Arrays;

public class Test {
    private static final RepositorioCliente repoCliente = new RepositorioCliente();
    private static final RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Joaquina");
        Long clienteId1 = repoCliente.create(cliente1);
        cliente1.setId(clienteId1);

        Reserva reserva1 = new Comida("Pasta", 2000);
        Reserva reserva2 = new Transporte("Salta", 5000);
        Reserva reserva3 = new Hotel("Hilton", 8000);
        Reserva reserva4 = new BoletoViaje("Cancun", 20000);
        Localizador localizador1 = new Localizador(clienteId1, Arrays.asList(reserva1, reserva2, reserva3, reserva4));

        cliente1.addLocalizador(localizador1);
        repoCliente.update(cliente1);

        caluclarCompra(localizador1);
        repoLocalizador.create(localizador1);

        System.out.println("-------------------------------------------");
        Reserva reserva5 = new Hotel("Hilton", 1000);
        Reserva reserva6 = new Hotel("Hilton", 12000);
        Reserva reserva7 = new BoletoViaje("Bariloche", 8000);
        Reserva reserva8 = new BoletoViaje("Barcelona", 20000);
        Localizador localizador2 = new Localizador(clienteId1, Arrays.asList(reserva5, reserva6, reserva7, reserva8));

        cliente1.addLocalizador(localizador2);
        repoCliente.update(cliente1);

        caluclarCompra(localizador2);
        repoLocalizador.create(localizador2);

        System.out.println("-------------------------------------------");
        Reserva reserva9 = new BoletoViaje("Australia", 40000);
        Localizador localizador3 = new Localizador(clienteId1, Arrays.asList(reserva9));

        cliente1.addLocalizador(localizador3);
        repoCliente.update(cliente1);

        caluclarCompra(localizador3);
        repoLocalizador.create(localizador3);

    }

    private static void caluclarCompra(Localizador localizador) {
        double totalCompra = 0;
        Cliente cli = repoCliente.findOne(localizador.getClienteId());
        double descuento = 1;
        double precioBase = localizador.getListaDeReservas().stream().mapToDouble(Reserva::getMontoAPagar).sum();

        if (alMenosDosLoc(localizador)){
            descuento = 0.95;
            totalCompra = precioBase * descuento;

        } else if(esPaqueteCompleto(localizador)){
            descuento = 0.90;
            totalCompra = precioBase * descuento;
        }else if(dosHotelDosViajes(localizador)){
            descuento = 0.95;
            totalCompra = precioBase * descuento;
        }else{
            totalCompra = precioBase;
        }

        localizador.setTotalCompra(totalCompra);
    }

    private static boolean alMenosDosLoc(Localizador localizador){
        Cliente cli = repoCliente.findOne(localizador.getClienteId());
        if (cli.getLocalizadores().size() >= 2){
            return true;
        }
        return false;
    }

    private static boolean esPaqueteCompleto(Localizador localizador){
        boolean bHotel = false, bBoleto = false, bComida = false, bTransporte = false;
        for(Reserva res: localizador.getListaDeReservas()){
            if(res.getReserva() instanceof Hotel){
                bHotel = true;
            }
            if(res.getReserva() instanceof BoletoViaje){
                bBoleto = true;
            }
            if(res.getReserva() instanceof Comida){
                bComida = true;
            }
            if(res.getReserva() instanceof Hotel){
                bTransporte = true;
            }

        }

        if(bHotel && bBoleto && bComida && bTransporte){
            return true;
        }
        return false;
    }

    private static boolean dosHotelDosViajes(Localizador localizador){
        int contHotel = 0, contViajes = 0;

        for(Reserva res: localizador.getListaDeReservas()){
            if(res instanceof Hotel){
                contHotel++;
            }
            if(res instanceof BoletoViaje){
                contViajes++;
            }
        }

        if(contHotel>=2 || contViajes>=2){
            return true;
        }
        return false;
    }
}
