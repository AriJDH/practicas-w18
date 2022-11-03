package com.meli;

import java.util.List;

public class Garage {
    private int id;
    private List<Car> carList;

    public Garage(int id, List<Car> carList) {
        this.id = id;
        this.carList = carList;
    }

    public int getId() {
        return id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
