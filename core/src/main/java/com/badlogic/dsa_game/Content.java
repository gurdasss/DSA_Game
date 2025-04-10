package com.badlogic.dsa_game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Content extends Table {

    private Label title;
    private Label mainText;

    public Content(Skin skin) {

        this.setSkin(skin);

        this.title = new Label("", skin);
        this.title.setFontScale(3);
        this.mainText = new Label("", skin);

        this.setDebug(true);

        this.defaults()
            .expand()
            .fill()
            .padLeft(50);


        this.add(title);
        this.row();
        this.add(mainText);
        this.row();

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setMainText(String mainText) {
        this.mainText.setText(mainText);
    }


}
