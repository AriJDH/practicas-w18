import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private List<Cliente> clientes;

    public RepositorioClientes() {
        this.clientes = new ArrayList<>();
    }

    public void agregaCliente(Cliente cliente){
        if (!clientes.contains(cliente)){
            clientes.add(cliente);
            System.out.println("Cliente Agregado");
        }else{
            System.out.println("Cliente ya existe");
        }
    }

    public Boolean descuentoPrevio(Cliente cliente, List<Localizador> localizadores){
        int cantidadLocalizadores = 0;
        for (Localizador localizador: localizadores
             ) {
            if (localizador.getCliente().equals(cliente)){
                cantidadLocalizadores++;
            }
        }
        return cantidadLocalizadores >= 2;
    }

    public Boolean esPaquete(Localizador localizador){
        Boolean tieneHotel = false;
        Boolean tieneBoleto = false;
        Boolean tieneComida = false;
        Boolean tieneTransporte = false;

        for (Reserva reserva: localizador.getReservas()
             ) {
            if (reserva instanceof ReservaHotel){tieneHotel = true;}
            if (reserva instanceof ReservaBoleto){tieneBoleto = true;}
            if (reserva instanceof ReservaComida){tieneComida = true;}
            if (reserva instanceof ReservaTransporte){tieneTransporte = true;}
        }

        return tieneBoleto && tieneHotel && tieneComida && tieneTransporte;
    }

    public void showClientes(){
        for (Cliente cliente: clientes
             ) {
            System.out.println(cliente);
        }
    }
}
