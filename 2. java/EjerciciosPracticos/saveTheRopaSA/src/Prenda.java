public class Prenda {

    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    //Presentación de cada prenda
    @Override
    public String toString() {
        return "Prenda de marca : " + marca +  " modelo:" + modelo ;
    }
}
