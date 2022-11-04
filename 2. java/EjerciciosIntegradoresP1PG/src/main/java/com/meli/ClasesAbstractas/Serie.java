package com.meli.ClasesAbstractas;

public abstract class Serie<T extends Number, K extends Number> {

    private T value;
    private K increment;

    public Serie(T value, K increment) {
        this.value = value;
        this.increment = increment;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setIncrement(K increment) {
        this.increment = increment;
    }

    public T getValue() {
        return this.value;
    }

    public K getIncrement() {
        return this.increment;
    }

    public void initialize(T value) {
        this.value = value;
    }

    public abstract T getNextValue();

    public abstract void restart();
}
