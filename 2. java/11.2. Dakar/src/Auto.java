public class Auto extends Vehiculo{

    //Opcion 1
    public Auto() {
        this.peso = 1000.00;
        this.ruedas = 4;
    }

    //opcion 2
    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000.00;
        this.ruedas = 4;
    }
}
