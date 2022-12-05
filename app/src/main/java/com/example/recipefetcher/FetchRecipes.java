package com.example.recipefetcher;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;


public class FetchRecipes extends AppCompatActivity {
    Button buttonFetchRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_recipes);

        buttonFetchRecipes = (Button) findViewById(R.id.buttonFetchRecipes);

        buttonFetchRecipes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}