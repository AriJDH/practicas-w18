package com.meli;

public class Car {
    private String model;
    private String brand;
    private double cost;

    public Car(String model, String brand, double cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getCost() {
        return cost;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }
}
