package com.meli.Dakar;

public abstract class Car {

    private double speed;
    private double acceleration;
    private double turningAngle;
    private String patent;
    private double weight;
    private double wheel;

    public Car(int speed, int acceleration, int turningAngle, String patent, int weight, int wheel) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.patent = patent;
        this.weight = weight;
        this.wheel = wheel;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public void setTurningAngle(int turningAngle) {
        this.turningAngle = turningAngle;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getTurningAngle() {
        return turningAngle;
    }

    public String getPatent() {
        return patent;
    }

    public double getWeight() {
        return weight;
    }

    public double getWheel() {
        return wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", acceleration=" + acceleration +
                ", turningAngle=" + turningAngle +
                ", patent='" + patent + '\'' +
                ", weight=" + weight +
                ", wheel=" + wheel +
                '}';
    }
}
