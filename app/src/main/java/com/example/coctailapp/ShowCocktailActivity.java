package com.example.coctailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

public class ShowCocktailActivity extends AppCompatActivity {



    private String drinkName;
    private String drinkGlass;
    private String drinkPhotoUrl;
    private String drinkInstructions;

    private ImageView cocktailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cocktail);

        // Fetch data from MainActivity and parse it to needed variables
        fetchAndParseData();


        // Draw everything on screen

        // fetch views
        TextView cocktailName = (TextView) findViewById(R.id.cocktailNameTextView);
        TextView cocktailInstructions = (TextView) findViewById(R.id.cocktailInstructionsTextView);

        cocktailView = (ImageView) findViewById(R.id.cocktailPhotoImageView);


        // Fetch photo and set it to cocktailView

        fetchPhoto();

        // Set texts
        cocktailName.setText(drinkName);
        cocktailInstructions.setText(drinkInstructions);



    }

    private void fetchAndParseData() {

        JSONArray cocktailArray = null;

        // Fetch data from Main Activity, convert it back to JSON object, to JSON array and extract data to variables
        if (getIntent().getStringExtra("DATA") != null) {
             String dataa = getIntent().getStringExtra("DATA");
            System.out.println("data not null");


            try {
               JSONObject cocktail = new JSONObject(dataa);
                cocktailArray = cocktail.getJSONArray("drinks");
            } catch (JSONException e) {
                e.printStackTrace();
            }


            for (int i = 0; i < cocktailArray.length(); i++) {
                try {
                    JSONObject oneObject = cocktailArray.getJSONObject(i);
                    drinkName = oneObject.getString("strDrink");
                    drinkGlass = oneObject.getString("strGlass");
                    drinkInstructions = oneObject.getString("strInstructions");
                    drinkPhotoUrl = oneObject.getString("strDrinkThumb");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        } else {
            System.out.println("data is null");
        }

    }

    private void fetchPhoto() {
        RequestQueue mQueue = Volley.newRequestQueue(this);

        ImageRequest imageRequest = new ImageRequest(drinkPhotoUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
            cocktailView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error fetching photo from url");
            }
        });

        mQueue.add(imageRequest);
    }


}










