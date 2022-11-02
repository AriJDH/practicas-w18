package com.meli.Asteroid;

import java.util.ArrayList;
import java.util.List;

public class ComposeSpaceship implements ISpaceship {

    private List<ISpaceship> spaceships = new ArrayList<>();

    public void addSpaceships(ISpaceship spaceships) {
        this.spaceships.add(spaceships);
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    public List<ISpaceship> getSpaceships() {
        return this.spaceships;
    }

    @Override
    public void setName() {
        return;
    }

    @Override
    public void setX(Integer x) {
        return;
    }

    @Override
    public void setY(Integer y) {
        return;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer getX() {
        return null;
    }

    @Override
    public Integer getY() {
        return null;
    }
}
