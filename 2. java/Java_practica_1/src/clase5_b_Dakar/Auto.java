package clase5_b_Dakar;

public class Auto extends Vehiculo{
    private static final Double PESO_DE_AUTO = 1000.0;
    public static final Integer RUEDAS = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_DE_AUTO, RUEDAS);
    }

    public Auto(){
        super();
    }

    @Override
    public String toString() {
        return "Auto{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
