public class Prenda {

    private String marca;
    private String modelo;

    public Prenda() {

    }


    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Datos de la prenda: " + "\n" +
                "Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo;
    }


}
