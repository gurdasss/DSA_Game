package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

public class ListProblem extends ProblemScreenConfig {

    public ListProblem(Game game) {
        super(game);

        DragAndDrop dragAndDrop = new DragAndDrop();

        for (int i = 0; i < 5; i++) {
            DataElement item = new DataElement(Integer.toString(i), skin);

            dragAndDrop.addSource(new DragAndDrop.Source(item) {
                @Override
                public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
                    DragAndDrop.Payload payload = new DragAndDrop.Payload();

                    payload.setDragActor(getActor());
                    payload.setObject(item.getDataValue());

                    dragAndDrop.setDragActorPosition(
                        getActor().getWidth() / 2f,
                        -getActor().getHeight()
                    );

                    return payload;
                }

                @Override
                public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {
                    if (target == null) {
                        sourceContainer.add(payload.getDragActor());
                        sourceContainer.pack();
                    }
                }
            });

            sourceContainer.add(item);
        }


        dragAndDrop.addTarget(new DragAndDrop.Target(targetContainer) {
            @Override
            public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                targetContainer.add(payload.getDragActor());
                System.out.println(payload.getObject());
                targetContainer.pack();
            }
        });
    }
}
