package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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

        TextButton testButton = new TextButton("TestButton", skin);
        TextButton homeButton = new TextButton("HOME", skin);

        footer.add(testButton).size(100).space(20);
        footer.add(homeButton).size(100).right();

        root.add(scrollPane).expand().fill();
        root.row();
        root.add(footer).expandX().bottom();

        stage.addActor(root);
    }


}
