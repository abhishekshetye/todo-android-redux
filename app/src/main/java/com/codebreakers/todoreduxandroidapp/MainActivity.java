package com.codebreakers.todoreduxandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codebreakers.todoreduxandroidapp.ui.SimpleLayout;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SimpleLayout(this));
    }
}
