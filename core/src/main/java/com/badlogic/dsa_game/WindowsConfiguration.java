package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

abstract class WindowsConfiguration {

    /*
     * This is the base class for all the windows
     * of this game. All the configurations will be
     * shared by all the child classes of this base class.
     */

    final protected Stage stage;
    final protected Skin skin;
    final protected ScreenViewport screenViewport;

    final protected Game game;


    public WindowsConfiguration(Game game) {

        this.screenViewport = new ScreenViewport();

        this.stage = new Stage(this.screenViewport);
        Gdx.input.setInputProcessor(this.stage);
        
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));

        this.game = game;

    }


}
