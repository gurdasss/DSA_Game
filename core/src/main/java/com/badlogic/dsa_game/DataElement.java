package com.badlogic.dsa_game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DataElement extends Container<Label> {
    final private String dataValue;

    public DataElement(String value, Skin skin) {

        super(new Label(value, skin));
        this.setTouchable(Touchable.enabled);

        dataValue = value;
        this.setBackground(skin.newDrawable("white", Color.BROWN));
    }

    public String getDataValue() {
        return dataValue;
    }


}
