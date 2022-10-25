package com.example.coctailapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;


import java.util.Properties;
import java.util.ResourceBundle;


public class MainActivity extends AppCompatActivity {

    private String randomCocktailUrl = BuildConfig.RANDOM_COCKTAIL_URL;
    private RequestQueue mQueue;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);

    }


    // Change to ShowCocktailActivity
   /* public void changeIntent(View view){



        Intent intent = new Intent(this, ShowCocktailActivity.class);
        intent.putExtra("DATA", data);
        startActivity(intent);
    }*/









    // Fetch JSON data from api
    public void changeIntent(View view) {


        // fetch random cocktail
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, randomCocktailUrl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            convertJson(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        mQueue.add(jsonObjectRequest);




    }

    private void convertJson(@NonNull JSONObject cocktail) throws JSONException {

        data = cocktail.toString();

        Intent intent = new Intent(this, ShowCocktailActivity.class);
        intent.putExtra("DATA", data);
        startActivity(intent);

    }



}

















