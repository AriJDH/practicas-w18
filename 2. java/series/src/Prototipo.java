public abstract class Prototipo {
    private int valorInicial;
    private int valorActual;

    public Prototipo(int valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract int siguiente();

    public void reiniciar() {
        this.valorActual = valorInicial;

    }

    protected int getValorInicial() {
        return valorInicial;
    }

    protected void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    protected int getValorActual() {
        return valorActual;
    }

    protected void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
}
