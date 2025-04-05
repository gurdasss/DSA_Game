package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class HomeScreen extends WindowsConfiguration implements Screen {

    public HomeScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        System.out.println("Welcome, HOME!!");
    }

    @Override
    public void render(float delta) {

        // Clear the screen and draw the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void resize(int width, int height) {
        screenViewport.update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        System.out.println("All HOME SCREEN Resources are whoosh!");
        stage.dispose();
        skin.dispose();

    }
}
