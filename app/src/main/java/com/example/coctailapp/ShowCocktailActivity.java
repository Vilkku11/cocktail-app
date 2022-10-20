package com.example.coctailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowCocktailActivity extends AppCompatActivity {

    // Data passed from MainActivity
    protected String dataa;
    // data back to JSON object
    JSONObject cocktail;
    JSONArray cocktailArray;
    String drink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cocktail);

        // fetching data from MainActivity


        if (getIntent().getStringExtra("DATA") != null) {
            dataa = getIntent().getStringExtra("DATA");
            System.out.println("data not null");


            try {
                cocktail = new JSONObject(dataa);
                cocktailArray = cocktail.getJSONArray("drinks");
            } catch (JSONException e) {
                e.printStackTrace();
            }


            for (int i=0; i < cocktailArray.length();i++ ){
                try {
                    JSONObject oneObject = cocktailArray.getJSONObject(i);
                    drink = oneObject.getString("strDrink");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        } else {
            System.out.println("data is null");
        }


        TextView testView = (TextView) findViewById(R.id.textView2);

       testView.setText(drink);


    }


}










