public class SerieDouble extends Prototipo {

    double salto;

    public SerieDouble(Double a) {
        super(a);
        this.salto = a;
    }

    public Double getNextValue() {
        return (Double) (this.value = this.value.doubleValue() + this.salto);

    }

    @Override
    public String toString() {
        return "La serie de " + this.salto + " inicio en " + this.initialValue +
                ", y su valor final es " + this.value;
    }
}

