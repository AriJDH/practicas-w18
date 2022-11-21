public class SerieTres extends Prototipo{

    public SerieTres(Double a) {
        super(a);
    }


    @Override
    public String toString() {
        return "La serie Triple inicio en " + initialValue +
                ", y su valor final es " + value;
    }
}
