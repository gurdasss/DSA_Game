package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;

public class Main extends Game {

    @Override
    public void create() {
        this.setScreen(new HomeScreen(this));
    }

}
