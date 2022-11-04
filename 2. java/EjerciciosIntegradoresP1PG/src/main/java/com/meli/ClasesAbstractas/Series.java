package com.meli.ClasesAbstractas;

public class Series extends Serie{

    public Series(Number value, Number increment) {
        super(value, increment);
    }

    @Override
    public Number getNextValue() {
        var sum = super.getValue().doubleValue() + super.getIncrement().doubleValue();
        setValue(sum);
        return sum;
    }

    @Override
    public void restart() {
        super.setValue(Double.NaN);
        super.setIncrement(Double.NaN);
    }

}
