package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

abstract class IntroScreen extends WindowsConfiguration {

    final protected Content content;

    public IntroScreen(Game game) {
        super(game);

        content = new Content(skin);

    }

    @Override
    public void show() {

        Table root = new Table();
        root.setFillParent(true);

//        Table content = new Table();
//


        ScrollPane scrollPane = new ScrollPane(content, skin);
        Table footer = new Table();

        TextButton testButton = new TextButton("TestButton", skin);
        TextButton testButton2 = new TextButton("TestButton 2", skin);

        footer.add(testButton).size(100).space(20);
        footer.add(testButton2).size(100).right();

        root.add(scrollPane).expand().fill();
        root.row();
        root.add(footer).expandX().bottom();

        stage.addActor(root);
    }

    @Override
    public void render(float delta) {

        // Clear the screen and draw the stage
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        screenViewport.update(width, height, true);

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
