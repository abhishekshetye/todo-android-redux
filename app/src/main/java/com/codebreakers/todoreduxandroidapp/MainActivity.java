package com.codebreakers.todoreduxandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.codebreakers.todoreduxandroidapp.redux.ActionType;
import com.codebreakers.todoreduxandroidapp.redux.State;
import com.codebreakers.todoreduxandroidapp.ui.SimpleLayout;

import trikita.anvil.Anvil;
import trikita.jedux.Action;
import trikita.jedux.Store;


public class MainActivity extends AppCompatActivity {


    private Store<Action<ActionType, ?>, State> store;
    private State state;
    private State.Reducer reducer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = new State(1);
        setContentView(new SimpleLayout(this, state));
    }


    public void increment(View view) {
        reducer.reduce(new Action<>(ActionType.INCREMENT) , state);
        Anvil.render();
    }
}
