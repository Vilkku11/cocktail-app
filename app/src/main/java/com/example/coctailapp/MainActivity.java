package com.example.coctailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // change to ShowCocktail activity
    public void changeIntent(View view) {
        Intent intent = new Intent(this, ShowCocktailActivity.class);
        startActivity(intent);
    }
}

