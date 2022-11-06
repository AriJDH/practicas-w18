package SerieNumerica;

public  abstract class Prototipo extends Number{

    protected Number initialValue = 0;
    protected Number value = 0;
    protected Number a = 0;

    public Prototipo(double a) {
        this.a = a;
    }

    public Number getNextvalue() {
        value = value + a;
        return value;
    }

    public Number resetSerie() {
        value = initialValue;
        return value;
    }

    public Number defineNewInitialValue(Number newValue){
        initialValue = newValue;
        return  initialValue;
    }
}
