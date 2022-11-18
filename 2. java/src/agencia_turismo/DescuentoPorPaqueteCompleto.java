package agencia_turismo;

public class DescuentoPorPaqueteCompleto implements EstrategiaDeDescuento {
    @Override
    public double calcularDescuento(Localizador localizador) {
        return localizador.esPaqueteCompleto() ? 0.1 * localizador.getTotal() : 0;
    }
}