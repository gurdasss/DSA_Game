package com.badlogic.dsa_game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main implements ApplicationListener {

    private Stage stage;
    private ScreenViewport screenViewport;

    @Override
    public void create() {
        // Prepare your application here.

        screenViewport = new ScreenViewport();
        stage = new Stage(screenViewport);
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        MainMenuWindow mainMenuWindow = new MainMenuWindow(skin);

        /*
            No need to create a Stack container because
            I can access all the Actors and Groups
            from the Stage using stage.getActors()
            in an Array.

            I can also change the drawing order
            of different actors just using their
            z-index.
         */

        stage.addActor(mainMenuWindow);

        System.out.println(stage.getActors().toString());


    }

    @Override
    public void resize(int width, int height) {
        // Resize your application here. The parameters represent the new window size.

        screenViewport.update(width, height, true);

    }

    @Override
    public void render() {
        // Draw your application here.

        // Clear the screen and draw the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
        stage.dispose();
    }
}
