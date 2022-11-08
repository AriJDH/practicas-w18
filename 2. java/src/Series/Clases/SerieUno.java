package Series.Clases;

public class SerieUno extends Prototipo {
    int value = 0;
    int valorSumar = 0;

    @Override
    public int getNextValue() {
        Integer nextValue = this.value + this.valorSumar;
        this.value = nextValue;
        return nextValue;
    }

    @Override
    public void setValueCero() {
        this.value = 0;
    }

    @Override
    public void setInitialValue(Object value) {
        if (this.value == 0) {
            this.valorSumar += (Integer) value;
            System.out.println(value);
        }
        this.value += (Integer) value;
    }

    @Override
    public String toString() {
        return "SerieUno{" +
                "value=" + value +
                '}';
    }
}
