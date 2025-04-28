package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

// TODO: Remember to change it back to abstract
public class ProblemScreenConfig extends WindowsConfiguration {

    final protected ContentTable contentTable;
    final protected Table mainTable;

    public ProblemScreenConfig(Game game) {
        super(game, "Some Problem Screen");
        contentTable = new ContentTable(skin);
        mainTable = new Table();
    }

    @Override
    public void show() {
        Table root = new Table();
        root.setFillParent(true);


        contentTable.setTitle("PROBLEM");
        contentTable.setMainText("jhkdsuiudsuijuij\n" +
            "sdahjbhjbcsdhbjscdhbj\n" +
            "kjsdujiksdjhkjhn\n");

        SplitPane splitPane = new SplitPane(contentTable, mainTable, false, skin);

        root.add(splitPane)
            .expand()
            .fill();
        root.row();

        stage.addActor(root);
    }
}
