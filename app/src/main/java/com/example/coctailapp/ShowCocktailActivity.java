package com.example.coctailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowCocktailActivity extends AppCompatActivity {

    // Data passed from MainActivity
    String data;
    // data back to JSON object
    JSONObject cocktail = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cocktail);

        // fetching data from MainActivity


        if (getIntent().getStringExtra("DATA") != null) {
            data = getIntent().getStringExtra("DATA");
            System.out.println("data not null");
            System.out.println(data);

            try {
                cocktail = new JSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("data is null");
        }


        TextView testView = (TextView) findViewById(R.id.textView2);

        if(cocktail != null) {
            try {

                String name = cocktail.getJSONObject("drinks").getString("strDrink");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("cocktail is nulll");
        }


    }


}










