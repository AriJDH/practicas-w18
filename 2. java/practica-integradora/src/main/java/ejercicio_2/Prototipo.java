package ejercicio_2;

public abstract class Prototipo {

    private int valorInicial;

    public Prototipo(int valorActual) {
        this.valorInicial = valorActual;
    }

    public abstract int devolverValor();
    public abstract void reiniciarSerie();
    public abstract void nuevoValorInicial(int valor);

    public void imprimir(Integer n) {
        System.out.println(n);
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorActual) {
        this.valorInicial = valorActual;
    }
}
