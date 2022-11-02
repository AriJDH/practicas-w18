package com.meli.Asteroid;

import java.util.List;

public class Player {

    private String nickName;
    private ISpaceship spaceship;

    public Player(String nickName, ISpaceship spaceship) {
        this.nickName = nickName;
        this.spaceship = spaceship;
    }

    public String getNickName() {
        return nickName;
    }

    public ISpaceship getSpaceship() {
        return spaceship;
    }

}
