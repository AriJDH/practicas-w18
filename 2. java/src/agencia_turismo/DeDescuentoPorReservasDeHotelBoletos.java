package agencia_turismo;

public class DeDescuentoPorReservasDeHotelBoletos implements EstrategiaDeDescuento {
    @Override
    public double calcularDescuento(Localizador localizador) {
        double dto = 0;
        if (localizador.cantidadDeReservasPorTipo(TipoReserva.BOLETO_VIAJE) >= 2) {
            dto += calcularDtoTotalTipoReserva(localizador, TipoReserva.BOLETO_VIAJE);
            if (localizador.cantidadDeReservasPorTipo(TipoReserva.HOTEL) >= 2)
                dto += calcularDtoTotalTipoReserva(localizador, TipoReserva.HOTEL);
        }
        return dto;
    }

    public double calcularDtoTotalTipoReserva(Localizador localizador, TipoReserva tipoReserva) {
        return localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(tipoReserva))
                .map(r -> {
                    double dtoReserva = 0.05 * r.getPrecio();
                    r.setPrecioPostDescuentos(r.getPrecio() - dtoReserva);
                    return dtoReserva;
                }).mapToDouble(d -> d).sum();
    }
}
