package repositorio;

import model.Cliente;
import model.Localizador;
import model.Paquete;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteRepositorio implements Create<Cliente>, ReadAll<Localizador> {

    private List<Paquete>reservas=new ArrayList<>();
    private List<Cliente> clientes=new ArrayList<>();

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void findAll(Cliente cliente) {

        clientes.stream()
                .filter(cliente1 -> cliente1.getId().equals(cliente.getId())).findFirst()
                .ifPresentOrElse(this::descuentos
                        ,()->create(cliente));

    }
    public void descuentos(Cliente cliente){
        AtomicInteger nroHotel= new AtomicInteger();
        AtomicInteger nroBoletos= new AtomicInteger();
        if (cliente.getLocalizadors().size()>=2)
            System.out.println("Tiene un 5% de descuentos en futuras compras");
        cliente.getLocalizadors().stream()
                .forEach(localizador ->
                        localizador
                                .getReservas().stream()
                                .forEach(reservas->{
                                    if (isCompleto(reservas))
                                        System.out.println("Tiene un 10% de descuento" +
                                                " extra por haber adquirido un paquete completp");
                                    if (reservas.isReserva())
                                        nroHotel.set(+1);
                                    if (reservas.isBoleto())
                                        nroBoletos.set(+1);
                                }));
        if (nroHotel.get()==2||nroBoletos.get()==2)
            System.out.println("Tiene un 5% de descuento en futuras compras por tener 2 reservas o 2 boletos");
    }
    private boolean isCompleto(Paquete paquete){
        return paquete.isBoleto()&&paquete.isComida()&&paquete.isReserva()&&paquete.isTransporte();
    }
}
