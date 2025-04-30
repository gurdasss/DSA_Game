package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

// TODO: Remember to change it back to abstract
public class ProblemScreenConfig extends WindowsConfiguration {

    final protected Label problemStatement;
    final protected Table canvasTable;

    public ProblemScreenConfig(Game game) {
        super(game, "Some Problem Screen");

        Table root = new Table();
        root.setFillParent(true);
        root.setDebug(true);

        Table footerButtonGroup = new Table();

        footerButtonGroup.add(new Label("FOOTER BUTTON GROUP", skin));


        problemStatement = new Label("", skin);
        canvasTable = new Table();

        root.add(problemStatement)
            .top()
            .left();

        root.row();
        root.add(canvasTable)
            .expand()
            .fill();

        root.row();

        root.add(footerButtonGroup)
            .expandX()
            .fillX()
            .size(50);


        stage.addActor(root);

    }


}
