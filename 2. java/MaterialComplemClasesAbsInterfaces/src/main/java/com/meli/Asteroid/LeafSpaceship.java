package com.meli.Asteroid;

public class LeafSpaceship implements ISpaceship {
    private String name;
    private int x;
    private int y;

    public LeafSpaceship(String name) {
        this.name = name;
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public void setName() {
        this.name = name;
    }

    @Override
    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getX() {
        return this.x;
    }

    @Override
    public Integer getY() {
        return this.y;
    }
}
