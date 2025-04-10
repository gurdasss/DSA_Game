package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class HomeScreen extends WindowsConfiguration {

    public HomeScreen(Game game) {
        super(game, "HOME SCREEN");
    }

    @Override
    public void show() {
        printWindowName();

        Table root = new Table();
        root.setFillParent(true);
        root.setDebug(true);

        // SETTING UP THE HEADER

        Table header = new Table();
        header.setDebug(true);
        header.defaults().space(10);

        Label testLabel = new Label("COMPLETED:", skin);
        ProgressBar progressBar = new ProgressBar(0, 100, 1, false, skin);
        TextButton quitButton = new TextButton("QUIT", skin);

        header.add(testLabel);

        header.add(progressBar)
            .expandX()
            .left();

        header.add(quitButton);

        // END OF HEADER SECTION


        // SETTING UP THE SCROLL PANE

        Table content = new Table();
        content.defaults().pad(10); // adds some spacing

        content.add(new ListSection(game, skin, Color.BLUE)).expandX().fill();
        content.row();
        content.add(new StackSection(game, skin, Color.BROWN)).expandX().fill();
        content.row();
        content.add(new QueueSection(game, skin, Color.CYAN)).expandX().fill();
        content.row();

        content.pack(); // calculates size based on content

        ScrollPane scrollPane = new ScrollPane(content, skin);

        // END OF SCROLL PANE SECTION

        root.add(header)
            .expandX()
            .fill();

        root.row();

        root.add(scrollPane)
            .expandX()
            .fill();

        stage.addActor(root);
    }


}
