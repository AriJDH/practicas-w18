public class Funcion1 extends Prototipo{

    int valorInicial;
    int valorSiguiente;

    @Override
    public int valorInicialSerie(int valorInicial) {
        return valorInicial;
    }

    @Override
    public int valorSiguiente(int valorSiguente) {
        valorSiguiente = valorInicial+valorSiguente;
        return valorSiguiente;
    }

    @Override
    public int reiniciarSerie() {
        return valorInicial=0;
    }


}
