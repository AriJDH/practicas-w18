package domain;

public abstract class SerieNumericaPrototype {
    private int valorInicial;
    protected int razon;
    protected int valorActual;

    public SerieNumericaPrototype(int valorInicial, int razon) {
        this.valorInicial = valorInicial;
        valorActual= valorInicial;
        this.razon = razon;
    }

    public abstract int next();

    public void setValorInicial(int valorInicial){
        this.valorInicial=valorInicial;
    }

    public void reiniciar(){
        this.valorActual=this.valorInicial;
    }

}
