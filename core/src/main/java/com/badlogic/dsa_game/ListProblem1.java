package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class ListProblem1 extends ProblemScreenConfig {

    public ListProblem1(Game game) {
        super(game);

        problemStatement.setText("Hello");

        HorizontalGroup list = new HorizontalGroup();
        Container<HorizontalGroup> container = new Container<>(list);
        container.setBackground(skin.newDrawable("white", Color.GOLD));

        List<String> dataContainer = new List<>(skin);


        for (int i = 0; i < 5; ++i) {
            dataContainer.getItems().add("[" + i + "]");
        }


        canvasTable.add(container)
            .size(400, 125)
            .expand();

        canvasTable.row();

        canvasTable.add(dataContainer)
            .size(200);

        DragAndDrop dragAndDrop = new DragAndDrop();

        dragAndDrop.addSource(new DragAndDrop.Source(dataContainer) {
            @Override
            public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();

                payload.setObject(dataContainer.getSelected());

                payload.setDragActor(new Label(dataContainer.getSelected(), skin));
                dataContainer.getItems().removeIndex(dataContainer.getSelectedIndex());

                return payload;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                if (target == null)
                    dataContainer.getItems().add((String) payload.getObject());
            }
        });

        dragAndDrop.addTarget(new DragAndDrop.Target(container) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                list.addActor(payload.getDragActor());
            }
        });


    }
}
