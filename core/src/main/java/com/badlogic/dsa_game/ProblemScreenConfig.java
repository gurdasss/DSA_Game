package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

// TODO: Remember to change it back to abstract
public class ProblemScreenConfig extends WindowsConfiguration {

    final protected Label problemStatement;
    final protected Table targetContainer;
    final protected Table sourceContainer;

    public ProblemScreenConfig(Game game) {
        super(game, "Some Problem Screen");

        problemStatement = new Label("SOME COMPLICATED PROBLEM!!!!", skin);
        targetContainer = new Table();
        sourceContainer = new Table();

        sourceContainer.defaults()
            .size(100)
            .space(20);

        targetContainer.setBackground(skin.newDrawable("white", Color.BLUE));

        targetContainer.defaults()
            .size(100)
            .space(20);

    }

    @Override
    public void show() {
        Table root = new Table();
        root.setFillParent(true);
//        root.setDebug(true);

        Table footer = new Table();

        footer.add(new Label("FOOTER BUTTON GROUP", skin));

        Table canvasTable = new Table();
        canvasTable.setDebug(true);

        targetContainer.add(new Label("TARGET", skin));


        canvasTable.add(targetContainer)
            .expand()
            .fill();

        canvasTable.row();

        canvasTable.add(sourceContainer)
            .expandX()
            .fillX();

        root.add(problemStatement)
            .top()
            .left();

        root.row();

        root.add(canvasTable)
            .expand()
            .fill();

        root.row();

        root.add(footer)
            .expandX()
            .fillX()
            .size(50);


        stage.addActor(root);

    }
}
