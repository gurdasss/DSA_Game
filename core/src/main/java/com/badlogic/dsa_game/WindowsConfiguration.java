package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

abstract class WindowsConfiguration extends ScreenAdapter {

    /*
     * This is the base class for all the windows
     * of this game. All the configurations will be
     * shared by all the child classes of this base class.
     */

    final protected Stage stage;
    final protected Skin skin;
    final protected ScreenViewport screenViewport;

    final protected Game game;

    // ONLY FOR DEBUGGING
    final private String windowName;


    public WindowsConfiguration(Game game, String windowName) {

        this.screenViewport = new ScreenViewport();

        this.stage = new Stage(this.screenViewport);
        Gdx.input.setInputProcessor(this.stage);

        this.skin = new Skin(Gdx.files.internal("uiskin.json"));

        this.game = game;

        this.windowName = windowName;

    }

    public void printWindowName() {
        System.out.println("Currently in " + windowName);
    }

    @Override
    public void render(float delta) {

        // Clear the screen and draw the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        System.out.println(windowName +
            " is been resized!");
        screenViewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        System.out.println("All " +
            windowName +
            " Resources are whoosh!");
        stage.dispose();
        skin.dispose();
    }
}
