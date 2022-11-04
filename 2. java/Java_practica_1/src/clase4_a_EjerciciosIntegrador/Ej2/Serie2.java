package clase4_a_EjerciciosIntegrador.Ej2;

public class Serie2<N extends Number> extends Serie<N>{

    @Override
    public N valorSiguiente() {
        this.valor = this.valor.doubleValue() + 2;
        return (N) this.valor;
    }
}
