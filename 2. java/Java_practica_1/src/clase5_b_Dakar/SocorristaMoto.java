package clase5_b_Dakar;

public class SocorristaMoto extends Moto implements ISocorro<Moto>{
    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public SocorristaMoto() {
    }

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto "+ moto.getPatente());
    }
}
