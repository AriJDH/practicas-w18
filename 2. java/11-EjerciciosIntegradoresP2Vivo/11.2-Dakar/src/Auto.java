public class Auto extends Vehiculo{

    // Constructores (podemos hacer de 2 maneras)
    // Opción 1
    public Auto() {
        this.peso = 1000.00;
        this.ruedas = 4;
    }

    // Opción 2
    public Auto(Double velocidad,
                Double aceleracion,
                Double anguloDeGiro,
                String patente) {
        super(velocidad,
                aceleracion,
                anguloDeGiro,
                patente);
        this.peso = 1000.00;
        this.ruedas = 4;
    }
}
