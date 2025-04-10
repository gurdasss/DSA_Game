package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

abstract class IntroScreen extends WindowsConfiguration {

    final protected Content content;


    public IntroScreen(Game game) {
        super(game, "SOME INTRO SCREEN");

        content = new Content(skin);

    }

    @Override
    public void show() {

        printWindowName();

        Table root = new Table();
        root.setFillParent(true);


        ScrollPane scrollPane = new ScrollPane(content, skin);
        scrollPane.setScrollingDisabled(true, false);


        Table footer = new Table();
        footer.setDebug(true, true);

        footer.defaults()
            .size(50)
            .space(50)
            .expandX()
            .fill();

        TextButton quitButton = new TextButton("QUIT", skin);
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                Gdx.app.exit();
            }
        });


        TextButton homeButton = new TextButton("HOME", skin);
        homeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new HomeScreen(game));

            }
        });

        footer.add(quitButton);
        footer.add(homeButton);

        root.add(scrollPane)
            .expand()
            .fill();

        root.row();

        root.add(footer)
            .expandX()
            .bottom();

        stage.addActor(root);
    }


}
