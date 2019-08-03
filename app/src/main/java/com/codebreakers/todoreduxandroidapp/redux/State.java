package com.codebreakers.todoreduxandroidapp.redux;

import trikita.jedux.Action;
import trikita.jedux.Store;

public class State {


    public final int count;

    public State (int count) {
        this.count = count;
    }


    public static class Reducer implements Store.Reducer<Action<ActionType, ?>, State> {

        @Override
        public State reduce(Action<ActionType, ?> actionTypeAction, State state) {
            switch (actionTypeAction.type) {
                case INCREMENT:
                    return new State(state.count + 1);
                case PLUS:
                    return new State(state.count +  (Integer) actionTypeAction.value);
            }
            return state;
        }
    }

}
