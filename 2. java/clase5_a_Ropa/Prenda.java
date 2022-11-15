package clase5_a_Ropa;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda de marca: '" + marca + '\'' + " y modelo: '" + modelo + '\'';
    }
}
