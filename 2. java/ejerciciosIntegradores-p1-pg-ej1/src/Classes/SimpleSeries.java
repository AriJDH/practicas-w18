package Classes;

public class SimpleSeries extends SeriesPrototype<Integer> {

    public SimpleSeries(Integer type, Integer initialValue) {
        super(type, initialValue);
    }

    @Override
    public Integer nextValue() {
        return this.currentValue+=this.type;
    }

    @Override
    public void restartSeries() {
        this.currentValue = this.initialValue;
    }

    @Override
    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }
}
