public class SerieTres extends Prototipo{

    private int valor;

    public SerieTres() {
        this.valor = 0;
    }

    @Override
    public int valorSiguiente(){
        this.valor += 3;
        return this.valor;
    }

    @Override
    public void valorInicial(int valor){
        this.valor = valor;
    }

    @Override
    public void reiniciarSerie() {
        this.valor = 0;
    }

}
