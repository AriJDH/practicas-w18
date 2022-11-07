public class Generador extends Prototipo {

    private Integer valor;

    public Generador() {

    }

    @Override
    public Integer valorSiguiente() {
        return valor = valor + 1;
    }

    @Override
    public void reiniciarSerie() {

        valor = 0;

    }

    @Override
    public void establecerValor(Integer numero) {
        valor = numero;
    }

    public Integer getValor() {
        return valor;
    }



}
