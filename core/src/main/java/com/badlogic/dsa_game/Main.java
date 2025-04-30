package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;

public class Main extends Game {

    @Override
    public void create() {
        // set the initial Game screen to Main Menu Screen
        this.setScreen(new ListProblem1(this));
    }

}
