package agencia_turismo;

import agencia_turismo.Repositories.ListRepository;

import java.util.*;

public class AnalizadorDeMetricas {
    private ListRepository<Localizador> localizadorListRepository;

    public AnalizadorDeMetricas(ListRepository<Localizador> localizadorListRepository) {
        this.localizadorListRepository = localizadorListRepository;
    }

    public long getCantidadDeLocalizadoresVendidos() {
        return localizadorListRepository.count();
    }

    public long getCantidadTotalDeReservas() {
        return this.getAllReservas().size();
    }

    private List<Reserva> getAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        for (Localizador localizador : localizadorListRepository.findAll()) {
            for (Reserva r : localizador.getReservas()) {
                reservas.add(r);
            }
        }
        return reservas;
    }

    public Map<TipoReserva, Long> dictionaryCantidadDeReservasPorTipo() {
        Map<TipoReserva, Long> dic = new HashMap<>();
        Arrays.stream(TipoReserva.values()).forEach(tipo ->
                dic.put(tipo, this.getAllReservas().stream().filter(r -> r.getTipoReserva().equals(tipo)).count()));
        return dic;
    }

    public double getTotalVentas() {
        return localizadorListRepository.findAll().stream().mapToDouble(loc -> loc.getTotal()).sum();
    }

    public double getPromedioVentas() {
        OptionalDouble optionalDouble =
                localizadorListRepository.findAll().stream().mapToDouble(loc -> loc.getTotal()).average();
        return optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0;
    }
}