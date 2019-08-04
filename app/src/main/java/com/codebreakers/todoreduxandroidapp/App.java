package com.codebreakers.todoreduxandroidapp;

import android.app.Application;

import com.codebreakers.todoreduxandroidapp.redux.ActionType;
import com.codebreakers.todoreduxandroidapp.redux.State;

import trikita.anvil.Anvil;
import trikita.jedux.Action;
import trikita.jedux.Store;

public class App extends Application {


    private static App instance;
    private Store<Action<ActionType, ?>, State> store;

    @Override
    public void onCreate() {
        super.onCreate();
        App.instance = this;
        store = new Store<>(new State.Reducer(), new State(1));
        this.store.subscribe(Anvil::render);
    }


    public static State getState() {
        return instance.store.getState();
    }


    public static State dispatch(Action<ActionType, ?> action) {
        return instance.store.dispatch(action);
    }
}
