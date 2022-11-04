package com.meli.SaveTheRopaSA;

public class Garmen {
    private String brand;
    private String model;

    public Garmen(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getMotel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMotel(String motel) {
        this.model = motel;
    }

    @Override
    public String toString() {
        return "Garmen{" +
                "brand='" + brand + '\'' +
                ", motel='" + model + '\'' +
                '}';
    }
}
