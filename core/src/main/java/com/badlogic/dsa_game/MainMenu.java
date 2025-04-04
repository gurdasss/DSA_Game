package com.badlogic.dsa_game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu extends WindowsConfiguration {
    public MainMenu(Stage stage, Skin skin) {
        super(stage, skin);

        TextButton playButton = new TextButton("PLAY", skin);
        this.add(playButton);
    }
}
