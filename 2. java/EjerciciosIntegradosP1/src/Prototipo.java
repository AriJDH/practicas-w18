import java.util.List;

public class Prototipo extends Number{
    Number valor;
    Number inicial;
    public Number siguiente(){
        return this.valor;
    }
    public Number reiniciar(){
        return this.valor = this.inicial;
    }

    public Number establecerInicial(Number inicial){
        return this.inicial= inicial;
    }

    public Number getInicial() {
        return inicial;
    }

    public void setInicial(Number inicial) {
        this.inicial = inicial;
    }

    public Prototipo(Number inicial, Number valor) {
        this.inicial = inicial;
        this.valor = valor;
    }

    public Number getValor() {
        return valor;
    }

    public void setValor(Number valor) {
        this.valor = valor;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
