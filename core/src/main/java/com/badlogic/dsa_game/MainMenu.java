package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu extends WindowsConfiguration implements Screen {

    public MainMenu(Game game) {
        super(game);

    }

    @Override
    public void show() {
        System.out.println("IN MAIN MENU!!");

        Table root = new Table();
        root.setFillParent(true);
        root.setBackground(skin.newDrawable("white", Color.WHITE));

        // a dummy Game image
        Texture gameImageTexture = new Texture(Gdx.files.internal("test.png"));
        Image gameImage = new Image(gameImageTexture);


        // setting the width and height of the image cell
        root.add(gameImage)
            .width(gameImage.getWidth() / 2.0f)
            .height(gameImage.getHeight() / 2.0f);

        root.row();

        TextButton playButton = new TextButton("PLAY", skin);

        // adding a functionality to the playButton

        /*
            ClickListener is mainly used to capture
            mouse click and touch in case of Android device.
         */
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game));
                dispose();
            }
        });

        TextButton quitButton = new TextButton("QUIT", skin);

        // adding a functionality to the quitButton
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("BYE-BYE!!");
                dispose();
                Gdx.app.exit();
            }
        });

        // setting up the following properties of the Cell:
        root.add(playButton)
            .width(500)
            .height(100)
            .space(25);

        root.row();

        root.add(quitButton)
            .width(500)
            .height(100);

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
        System.out.println("All MAIN-MENU Resources are whoosh!");
        stage.dispose();
        skin.dispose();

    }
}
