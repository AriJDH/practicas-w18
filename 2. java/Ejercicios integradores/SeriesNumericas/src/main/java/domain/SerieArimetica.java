package domain;

public class SerieArimetica extends SerieNumericaPrototype{
    public SerieArimetica(int valorInicial, int razon) {
        super(valorInicial, razon);
    }

    @Override
    public int next(){
        int val = super.valorActual;
        super.valorActual += super.razon;
        return val;
    }
}
