public abstract class Prototipo extends Number{

    Number initialValue = 0;
    Number value = 0;
    Number saltoSerie = 0;

    public Prototipo(Number salto) {
        this.saltoSerie = salto;
    }

    public Number getInitialValue() {
        return initialValue;
    }

    public Number getValue() {
        return value;
    }

    public Number getSaltoSerie() {
        return saltoSerie;
    }

    public Number getNextValue() {
        return value;
    }

    public void resetSerie() {
        this.value = initialValue;
    }

    public void setInitialValue(Number initialV) {
        this.initialValue = initialV;
        //this.value = initialV;
    }

}
