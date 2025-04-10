package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

abstract class IntroScreen extends WindowsConfiguration {

    /*
     * This is the base class for all Introduction type
     * screens for List, Stack, Queue, etc.
     * This class have already some common UI and
     * common buttons with some functionalities
     * of each buttons.
     */

    final protected ContentTable contentTable;

    public IntroScreen(Game game) {
        super(game, "SOME INTRO SCREEN");

        /*
         * Initialize a new ContentTable that will act
         * as the content of the ScrollPane.
         */
        contentTable = new ContentTable(skin);

    }

    @Override
    public void show() {

        printWindowName();

        Table root = new Table();
        root.setFillParent(true);


        ScrollPane scrollPane = new ScrollPane(contentTable, skin);
        // Disable the horizontal scroll bar
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
                // Dispose the current instance of this screen
                dispose();
                // Exit the game entirely
                Gdx.app.exit();
            }
        });


        TextButton homeButton = new TextButton("HOME", skin);
        homeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Dispose the current instance of this screen
                dispose();
                // Set the current active screen to Home Screen
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
