package series;

public abstract class Serie<N extends Number> {
    protected Number valor=0.0;
    protected Number valorInicial=0.0;

    public abstract N devolverNroSiguiente();

    public void reiniciar() {
        this.valor = this.valorInicial;
    }

    public void setValorInicial(N valorInicial) {
        this.valorInicial = valorInicial;
    }
}
