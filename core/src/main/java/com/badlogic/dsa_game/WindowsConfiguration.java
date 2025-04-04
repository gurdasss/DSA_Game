package com.badlogic.dsa_game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


abstract class WindowsConfiguration extends Table {

    /*
     * This is the base class for all the windows
     * of this game. All the configurations will be
     * shared by all the child classes of this base class.
     */


    public WindowsConfiguration(Stage stage, Skin skin) {

        this.setStage(stage);
        this.setSkin(skin);


        this.setFillParent(true);
        this.setDebug(true, true);
        this.setBackground(skin.newDrawable("white", Color.WHITE));


    }


}
