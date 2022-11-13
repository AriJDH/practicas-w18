import modelo.*;
import repositorio.ClienteRepository;
import repositorio.LocalizadorRepository;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        TipoReserva hotel = new ReservaHotel("Hotelucho", 200.0);
        TipoReserva transporte = new ReservaTransporte("Uber", 500.0);
        TipoReserva boletos = new ReservaBoletosDeViaje("Ida a Cancun", 5000.0);
        TipoReserva comida = new ReservaComida("Pensión Completa", 3000.0);

        TipoReserva paquete = new PaqueteTuristico("All inclusive, bien top",Arrays.asList(hotel, transporte, boletos, comida));

        Cliente cliente1 = new Cliente(1l, "Gabi", "Ortega", "6364926", "287398147");
        Localizador localizador = new Localizador(1l, cliente1, Arrays.asList(paquete));

        ClienteRepository cRepo = new ClienteRepository();
        cRepo.add(cliente1);

        LocalizadorRepository lRepo = new LocalizadorRepository();
        lRepo.add(localizador);

        System.out.println(cRepo.getOne(1l));
        System.out.println(lRepo.getOne(1l));

    }
}
