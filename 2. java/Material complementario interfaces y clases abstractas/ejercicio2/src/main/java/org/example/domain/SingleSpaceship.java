package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class SingleSpaceship extends SpaceshipComponent{
    private SpacePoint location;
    private String name;

    public SingleSpaceship(SpacePoint location, String name) {
        this.location = location;
        this.name = name;
    }

    public SpacePoint getLocation() {
        return location;
    }

    public void setLocation(SpacePoint location) {
        this.location = location;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double calculateDistance(SpacePoint spacePoint){
        return SpacePoint.calculateDistance(this.location, spacePoint);
    }


}
