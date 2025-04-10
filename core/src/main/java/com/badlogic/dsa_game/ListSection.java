package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ListSection extends SectionConfiguration {

    public ListSection(Game game, Skin skin, Color bgColor) {
        super("LIST", skin, bgColor);

        introButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Welcome, to LIST");

                // Get rid of previous screen (HomeScreen)
                game.getScreen().dispose();
                
                game.setScreen(new ListIntroScreen(game));
            }
        });
    }


}
