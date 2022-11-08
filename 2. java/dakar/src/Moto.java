public class Moto extends Vehiculo{

    public Moto(Integer velocidad, Integer aceleración, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleración, anguloDeGiro, patente);
        super.setPeso(300.0);
        super.setRuedas(2);
    }

    public Moto() {
    }

    @Override
    public String toString() {
        return super.toString() ;
    }
}
