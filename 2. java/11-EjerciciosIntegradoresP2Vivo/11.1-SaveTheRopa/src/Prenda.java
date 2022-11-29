public class Prenda {

    // Atributos
    private String marca;
    private String modelo;

    // Constructores
    public Prenda() {
    }

    public Prenda(String marca,
                  String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    // Métodos
    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
