package clase5_b_Dakar;

public class Moto extends Vehiculo{
    private static final Double PESO_DE_MOTO = 300.0;
    public static final int RUEDAS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_DE_MOTO, RUEDAS);
    }

    public Moto() {
    }

    @Override
    public String toString() {
        return "Moto{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
