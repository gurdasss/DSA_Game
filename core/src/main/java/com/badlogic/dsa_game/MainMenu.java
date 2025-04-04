package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu extends WindowsConfiguration implements Screen {

    public MainMenu(Game game) {
        super(game);

    }

    @Override
    public void show() {
        System.out.println("IN MAIN MENU!!");

        Table root = new Table();
        root.setFillParent(true);

        TextButton playButton = new TextButton("PLAY", skin);

        TextButton quitButton = new TextButton("QUIT", skin);

        root.add(playButton).width(500).height(100).space(25);
        root.row();
        root.add(quitButton).width(500).height(100);

        stage.addActor(root);

    }

    @Override
    public void render(float delta) {

        // Clear the screen and draw the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();

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
        stage.dispose();
        skin.dispose();

    }
}
