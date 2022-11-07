package ejercicio1.model;

public class Serie2 extends Prototipo {

    private static final int valorIncremento = 2;


    public Serie2() {
        super.valor = 0;
        super.valorInicial = valor;
        super.siguienteValor = valorIncremento;
    }

    @Override
    public Number getValor() {
        return super.valor;
    }

    @Override
    public Number getValorInicial() {
        return super.valorInicial;
    }

    @Override
    public void setValorInicial(Number valorInicial) {

        super.valorInicial = valorInicial;
        super.valor = valorInicial;
    }

    @Override
    public Number getSiguienteValor() {

        super.valor = super.valor.doubleValue() + super.siguienteValor.doubleValue();
        return getValor();
    }

    @Override
    public void reiniciarSerie() {
        super.valor = 0;
        super.valorInicial = 0;
        System.out.println("SERIE REINICIADA !");
    }

}
