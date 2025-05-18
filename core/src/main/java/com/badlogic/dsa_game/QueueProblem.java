package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Queue;

public class QueueProblem extends ProblemScreenConfig {

    private Queue<DataElement> testQueue;

    public QueueProblem(Game game) {
        super(game);

        DragAndDrop dragAndDrop = new DragAndDrop();

        Queue<Actor> dataElementQueue = new Queue<>();

        testQueue = new Queue<>();
        testQueue.addLast(new DataElement("3", skin));
        testQueue.addLast(new DataElement("1", skin));
        testQueue.addLast(new DataElement("4", skin));
        testQueue.addLast(new DataElement("5", skin));
        testQueue.addLast(new DataElement("2", skin));


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

                        // if queue is not empty
                        if (!dataElementQueue.isEmpty()) {
                            // then remove the first element from the queue
                            dataElementQueue.removeFirst();

                            // if queue is not empty
                            if (!dataElementQueue.isEmpty()) {
                                // set newly first element to enable
                                dataElementQueue.first().setTouchable(Touchable.enabled);
                            }
                        }

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

                Actor currentDataElement = payload.getDragActor();

                // check if the queue is not empty
                if (!dataElementQueue.isEmpty()) {
                    // if target container's first element is equal to queue's first element
                    if (targetContainer.getChildren().first().equals(dataElementQueue.first())) {
                        // then enable that element
                        targetContainer.getChildren().first().setTouchable(Touchable.enabled);
                    } else {
                        // otherwise set the back element to disable
                        currentDataElement.setTouchable(Touchable.disabled);
                    }
                }


                targetContainer.add(currentDataElement);
                dataElementQueue.addLast(currentDataElement);
                checkButton.setDisabled(!sourceContainer.getChildren().isEmpty());


            }
        });


    }

    @Override
    protected boolean checkSequence() {
        boolean flag = false;

        for (int i = 0; i < 5; i++) {

            String targetVal = ((DataElement) targetContainer.getChild(i)).getDataValue();
            String currentVal = testQueue.get(i).getDataValue();

            flag = targetVal.equals(currentVal);
        }

        return flag;
    }
}
