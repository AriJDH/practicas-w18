package Paquete;

public class SerieDeTres extends Prototipo {
    int valorIni;

    @Override
    public void valorInicial(Object valorIni) {
        this.valorIni=(Integer) valorIni;
    }

    @Override
    public Object valorSiguiente() {
       this.valorIni+=3;
       return valorIni;
    }

    @Override
    public void reiniciarSerie() {
        this.valorIni=0;

    }
}
