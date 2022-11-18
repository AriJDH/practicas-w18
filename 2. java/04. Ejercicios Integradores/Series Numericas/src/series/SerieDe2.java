package series;

public class SerieDe2<N extends Number> extends Serie<N>{
    @Override
    public N devolverNroSiguiente() {
        this.valor = this.valor.doubleValue() + 2;
        return (N) this.valor;
    }
}
