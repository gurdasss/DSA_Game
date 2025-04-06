package com.badlogic.dsa_game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

abstract class SectionConfiguration extends Table {

    /*
     * This is the base class for all the Data Structure
     * section of this game. All the configurations
     * and common UI and UI elements will be
     * shared by all the child classes of this base class.
     */

    final protected TextButton introButton;
    final protected TextButton problem1;
    final protected TextButton problem2;
    final protected TextButton problem3;


    public SectionConfiguration(String sectionTitle, Skin skin, Color bgColor) {

        this.add(new Label(sectionTitle, skin));
        this.row();
        this.setDebug(true, true);
        this.setSkin(skin);
        this.setBackground(skin.newDrawable("white", bgColor));

        // Setting up common UI for each section
        introButton = new TextButton("INTRO", skin);
        problem1 = new TextButton("PROBLEM 1", skin);
        problem2 = new TextButton("PROBLEM 2", skin);
        problem3 = new TextButton("PROBLEM 3", skin);


        this.add(introButton)
            .size(100)
            .padRight(500);

        this.row();

        this.add(problem1)
            .size(100)
            .padLeft(500);

        this.row();

        this.add(problem2)
            .size(100)
            .padRight(500);

        this.row();

        this.add(problem3)
            .size(100)
            .padLeft(500);

    }


}
