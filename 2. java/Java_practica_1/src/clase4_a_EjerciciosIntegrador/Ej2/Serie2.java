package clase4_a_EjerciciosIntegrador.Ej2;

public class Serie2<N extends Number> extends Serie<N>{

    @Override
    public N valorSiguiente() {
        double valorSiguiente = this.valor.doubleValue();
        valorSiguiente += 2.0;
        this.valor = valorSiguiente;
        return (N) this.valor;
    }
}
