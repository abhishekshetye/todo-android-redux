package com.codebreakers.todoreduxandroidapp.ui;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import com.codebreakers.todoreduxandroidapp.redux.ActionType;
import com.codebreakers.todoreduxandroidapp.redux.State;

import trikita.anvil.Anvil;
import trikita.anvil.RenderableView;
import trikita.jedux.Action;

import static trikita.anvil.BaseDSL.MATCH;
import static trikita.anvil.BaseDSL.WRAP;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.button;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.onClick;
import static trikita.anvil.DSL.orientation;
import static trikita.anvil.DSL.textView;

public class SimpleLayout extends RenderableView {

    private State state;
    private final State.Reducer reducer;

    public SimpleLayout(Context context, State state) {
        super(context);
        this.state = state;
        this.reducer = new State.Reducer();
    }

    @Override
    public void view() {
        linearLayout(() -> {
            orientation(LinearLayout.VERTICAL);
            textView(() -> {
                size(MATCH, WRAP);
                text("Counter : " + state.count);
            });
            button(() -> {
                text("Increment");
                onClick(v -> {
                    state = reducer.reduce(new Action<>(ActionType.INCREMENT) , state);
                    Anvil.render();
                    Log.d("SLIMF", state.count + " is the current count in state");
                });
            });
        });
    }

}
