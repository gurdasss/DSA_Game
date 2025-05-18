package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

// TODO: Remember to change it back to abstract
abstract public class ProblemScreenConfig extends WindowsConfiguration {

    final protected Label problemStatement;
    final protected Table targetContainer;
    final protected Table sourceContainer;
    final protected TextButton checkButton;

    public ProblemScreenConfig(Game game) {
        super(game, "Some Problem Screen");

        problemStatement = new Label("SOME COMPLICATED PROBLEM!!!!", skin);
        targetContainer = new Table();
        sourceContainer = new Table();

        checkButton = new TextButton("Check", skin);
        checkButton.setDisabled(true);

        checkButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (checkSequence()) {
                    System.out.println("Correct Answer!");
                } else {
                    System.out.println("Wrong Answer!");
                }
            }
        });

        sourceContainer.defaults()
            .size(100)
            .space(20);

        targetContainer.setBackground(skin.newDrawable("white", Color.BLUE));

        targetContainer.defaults()
            .size(100)
            .space(20);

    }

    abstract protected boolean checkSequence();

    @Override
    public void show() {
        Table root = new Table();
        root.setFillParent(true);
//        root.setDebug(true);

        Table footer = new Table();

        footer.add(checkButton)
            .expand()
            .fill();

        Table canvasTable = new Table();
        canvasTable.setDebug(true);


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
