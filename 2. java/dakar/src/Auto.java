public class Auto extends Vehiculo{


    public Auto(Integer velocidad, Integer aceleración, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        super.setPeso(1000.0);
        super.setRuedas(4);
    }

    public Auto() {
    }

    @Override
    public String toString() {
        return super.toString() ;
    }
}
