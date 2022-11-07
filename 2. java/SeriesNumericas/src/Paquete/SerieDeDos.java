package Paquete;

public class SerieDeDos extends Prototipo {
    double valorIni;

    @Override
    public void valorInicial(Object valorIni) {
        this.valorIni=(Double) valorIni;
    }

    @Override
    public Object valorSiguiente() {
        this.valorIni+=2;
        return valorIni;
    }

    @Override
    public void reiniciarSerie() {
        this.valorIni=0;

    }
}