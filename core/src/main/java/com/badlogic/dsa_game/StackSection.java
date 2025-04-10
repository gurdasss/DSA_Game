package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class StackSection extends SectionConfiguration {

    public StackSection(Game game, Skin skin, Color bgColor) {
        super("STACK", skin, bgColor);

        introButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Welcome, to STACK");
                game.setScreen(new StackIntroScreen(game));
            }
        });
    }
}
