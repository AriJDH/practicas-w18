package series;

public class SerieDe3<N extends Number> extends Serie<N> {
    @Override
    public N devolverNroSiguiente() {
        this.valor = this.valor.doubleValue() + 3;
        return (N)this.valor;
    }
}
