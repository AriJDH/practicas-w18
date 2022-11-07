public class Moto extends Vehiculo{

    // Constructores
    public Moto() {
        this.peso = 300.00;
        this.ruedas = 2;
    }

    public Moto(Double velocidad,
                Double aceleracion,
                Double anguloDeGiro,
                String patente) {
        super(velocidad,
                aceleracion,
                anguloDeGiro,
                patente);
        this.peso = 300.00;
        this.ruedas = 2;
    }


}
