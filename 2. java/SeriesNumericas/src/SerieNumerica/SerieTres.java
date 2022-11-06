package SerieNumerica;

public class SerieTres extends Prototipo{

    public SerieTres(Double a) {
        super(a);
    }

    @Override
    public Double getNextvalue() {
        return super.getNextvalue();
    }

    @Override
    public Double resetSerie() {
        return super.resetSerie();
    }

    @Override
    public Double defineNewInitialValue(Double newValue) {
        return super.defineNewInitialValue(newValue);
    }

    @Override
    public String toString() {
        return "La serie triple inicio en: " + initialValue +
                ", y su valor final es; " + value;
    }
}
