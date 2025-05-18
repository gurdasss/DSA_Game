package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Array;

public class ListProblem extends ProblemScreenConfig {

    final private Array<DataElement> dataElementArray;

    public ListProblem(Game game) {
        super(game);

        DragAndDrop dragAndDrop = new DragAndDrop();

        dataElementArray = new Array<>();

        dataElementArray.add(new DataElement("5", skin));
        dataElementArray.add(new DataElement("3", skin));
        dataElementArray.add(new DataElement("2", skin));
        dataElementArray.add(new DataElement("1", skin));
        dataElementArray.add(new DataElement("4", skin));

        problemStatement.setText(dataElementArray.toString());


        for (int i = 1; i <= 5; i++) {
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
                        checkButton.setDisabled(true);
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

                DataElement currentDataElement = ((DataElement) payload.getDragActor());

                targetContainer.add(currentDataElement);

                checkButton.setDisabled(!sourceContainer.getChildren().isEmpty());
            }
        });
    }

    @Override
    protected boolean checkSequence() {
        boolean flag = false;

        for (int i = 0; i < 5; i++) {

            String targetVal = ((DataElement) targetContainer.getChild(i)).getDataValue();
            String currentVal = dataElementArray.get(i).getDataValue();

            flag = targetVal.equals(currentVal);
        }

        return flag;
    }
}
