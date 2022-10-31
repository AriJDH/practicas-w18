package org.example.domain;

public class SpacePoint {
    private int x;
    private int y;

    public SpacePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double calculateDistance(SpacePoint point1, SpacePoint point2){
        return Math.sqrt(Math.pow(point1.x-point2.x,2)+Math.pow(point1.y-point2.y,2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
