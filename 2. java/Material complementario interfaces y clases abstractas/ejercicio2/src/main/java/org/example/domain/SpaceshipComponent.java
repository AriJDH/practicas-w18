package org.example.domain;

public abstract class SpaceshipComponent {
    private int points = 0;

    public void addPoint(){
        points++;
    }
    public abstract String getName();
    public abstract double calculateDistance(SpacePoint spacePoint);

    public int getPoints() {
        return points;
    }
}
