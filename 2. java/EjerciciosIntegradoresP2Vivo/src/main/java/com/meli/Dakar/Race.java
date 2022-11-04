package com.meli.Dakar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private double distance;
    private double prizeDollars;
    private String name;
    private long numberVehicles;
    private List<Car> carList = new ArrayList<>();
    private LifeGuardMoto lifeGuardMoto = new LifeGuardMoto();
    private LifeGuardAuto lifeGuardAuto = new LifeGuardAuto();

    public Race(double distance, double prizeDollars, String name, int numberVehicles) {
        this.distance = distance;
        this.prizeDollars = prizeDollars;
        this.name = name;
        this.numberVehicles = numberVehicles;
    }

    public void registerAuto(int speed, int acceleration, int turningAngle, String patent) {
        if (!validationRegistered()) {
            System.out.println("No se puede inscribir a nadie más en la carrera");
        } else {
            this.carList.add(new Auto(speed, acceleration, turningAngle, patent));
        }
    }

    private boolean validationRegistered() {
        if (numberVehicles == this.carList.stream().count()) {
            return false;
        }
        return true;
    }

    public void registerMotorcycle(int speed, int acceleration, int turningAngle, String patent) {
        if (!validationRegistered()) {
            System.out.println("No se puede inscribir a nadie más en la carrera");
        } else {
            this.carList.add(new Auto(speed, acceleration, turningAngle, patent));

        }
    }

    public void deleteAuto(Car auto) {
        this.carList.remove(auto);
    }

    public void deleteMotorcycle(Car moto) {
        this.carList.remove(moto);
    }

    public Car getChampion() {
        double valueChampion = Double.NaN;
        double aux = Double.NaN;
        Car champion = null;
        for (var c : this.carList) {
            aux = (c.getSpeed() * (c.getAcceleration() / 2)) / ((c.getTurningAngle()) * (c.getWeight() - c.getWheel() * 100));
            if (Double.isNaN(valueChampion)) {
                valueChampion = aux;
                champion = c;
            } else {
                if (aux > valueChampion) {
                    valueChampion = aux;
                    champion = c;
                }
            }
        }
        return champion;
    }

    public void helpAuto(String patent) {
        var car = this.carList.stream().filter(c -> c.getPatent().equals(patent)).findFirst().orElse(null);
        System.out.println(car.getClass());
        lifeGuardAuto.help((Auto) car);
    }

    public void helpMoto(String patent) {
        var car = this.carList.stream().filter(c -> c.getPatent().equals(patent)).findFirst().orElse(null);
        lifeGuardMoto.help((Motorcycle) car);
    }
}
