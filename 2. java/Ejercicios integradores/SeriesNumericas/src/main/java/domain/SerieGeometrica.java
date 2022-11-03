package domain;

public class SerieGeometrica extends SerieNumericaPrototype{
    public SerieGeometrica(int valorInicial, int razon) {
        super(valorInicial, razon);
    }

    @Override
    public int next() {
        int val = super.valorActual;
        super.valorActual *= super.razon;
        return val;
    }
}
