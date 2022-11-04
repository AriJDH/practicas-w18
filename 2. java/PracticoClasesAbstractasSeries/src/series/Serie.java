package series;

public abstract class Serie<T extends Number> {
    private T valorinicial;
    private T valorActual;

    public Serie(T valorinicial) {
        this.valorinicial = valorinicial;
        this.valorActual = valorinicial;
    }

    public T getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(T valorinicial) {
        this.valorinicial = valorinicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    public void configurarValorInicial(T num){
        this.valorinicial = num;
        this.valorActual = num;
    }
    public void reiniciarSerie(){
        this.valorActual = this.valorinicial;
    }
    public abstract T siguienteValor();
}
