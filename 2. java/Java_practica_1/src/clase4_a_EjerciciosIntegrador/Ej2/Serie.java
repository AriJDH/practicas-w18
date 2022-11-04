package clase4_a_EjerciciosIntegrador.Ej2;

public abstract class Serie<N extends Number> {

    protected Number valor = 0.0;
    protected Number valorInicial = 0.0;
    public abstract N valorSiguiente();
    public void reiniciar(){
        this.valor = this.valorInicial;
    }
    public void setValorInicial(N valorInicial){
        this.valor = valorInicial;
    }
}
