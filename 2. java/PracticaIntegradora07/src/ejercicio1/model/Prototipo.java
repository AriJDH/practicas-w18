package ejercicio1.model;

public abstract class Prototipo<T extends Number> {

    protected Number valor;
    protected Number valorInicial;
    protected Number siguienteValor;

    public abstract T getValor();

    public abstract T getValorInicial();

    public abstract void setValorInicial(T valorInicial);

    public abstract T getSiguienteValor();

    public abstract void reiniciarSerie();


}
