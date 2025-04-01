package com.badlogic.dsa_game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenuWindow extends Table {

    final private TextButton playButton;

    public MainMenuWindow(Skin skin) {
        super();
        this.setFillParent(true);
        this.setBackground(skin.newDrawable("white", Color.WHITE));

        this.setDebug(true, true);

        playButton = new TextButton("PLAY", skin);

        this.add(playButton).width(450).height(150);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        playButton.draw(batch, parentAlpha);
        super.draw(batch, parentAlpha);
    }
}
