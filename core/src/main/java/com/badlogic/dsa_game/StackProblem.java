package com.badlogic.dsa_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import java.util.Stack;

public class StackProblem extends ProblemScreenConfig {

    private Stack<DataElement> testStack;

    public StackProblem(Game game) {
        super(game);


        DragAndDrop dragAndDrop = new DragAndDrop();

        Stack<Actor> dataElementStack = new Stack<>();
        testStack = new Stack<>();

        testStack.push(new DataElement("3", skin));
        testStack.push(new DataElement("2", skin));
        testStack.push(new DataElement("5", skin));
        testStack.push(new DataElement("1", skin));
        testStack.push(new DataElement("4", skin));

        problemStatement.setText(testStack.toString());


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

                        // check is the data element stack is not empty
                        if (!dataElementStack.isEmpty()) {

                            // if so, pop the top element
                            dataElementStack.pop();

                            // check again if the data element stack is empty
                            if (dataElementStack.empty())
                                // if so, simply add the drag actor in the source container
                                sourceContainer.add(payload.getDragActor());
                            else
                                // if not empty, simply make the previous top element
                                // active
                                dataElementStack.peek().setTouchable(Touchable.enabled);
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

                Actor currentTopDataElement = payload.getDragActor();

                if (!dataElementStack.isEmpty()) {

                    Actor previousTopDataElement = dataElementStack.peek();

                    // set the previous top data element to inactive
                    previousTopDataElement.setTouchable(Touchable.disabled);

                }

                targetContainer.add(currentTopDataElement);
                dataElementStack.push(currentTopDataElement);

                checkButton.setDisabled(!sourceContainer.getChildren().isEmpty());

            }
        });
    }

    @Override
    protected boolean checkSequence() {
        boolean flag = false;

        for (int i = 0; i < 5; i++) {

            String targetVal = ((DataElement) targetContainer.getChild(i)).getDataValue();
            String currentVal = testStack.get(i).getDataValue();

            flag = targetVal.equals(currentVal);
        }

        return flag;
    }
}
