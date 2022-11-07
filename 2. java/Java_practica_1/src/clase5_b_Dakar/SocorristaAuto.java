package clase5_b_Dakar;

public class SocorristaAuto extends Auto implements ISocorro<Auto> {
    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public SocorristaAuto() {
    }

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto " + auto.getPatente());
    }
}
