package com.example.coctailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowCocktailActivity extends AppCompatActivity {

    private String data = getIntent().getStringExtra("data");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cocktail);
    }

    public void showData(String data){
        try {
            JSONObject json = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}