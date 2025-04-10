package com.badlogic.dsa_game;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ContentTable extends Table {

    /*
     * This is a custom Table that will be used
     * as the Content Table of the ScrollPane
     * in the IntroScreen class.
     */

    // TODO: Don't forget to add an Animation as one of field of this class!!

    final private Label title;
    final private Label mainText;

    public ContentTable(Skin skin) {

        // Configuration of this class

        this.setDebug(true);

        this.defaults()
            .expand()
            .fill()
            .padLeft(50);

        // End of configuration

        this.title = new Label("", skin);
        this.title.setFontScale(3);

        this.mainText = new Label("", skin);

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
