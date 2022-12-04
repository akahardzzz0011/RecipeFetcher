package com.example.recipefetcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonFetchRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFetchRecipes = (Button) findViewById(R.id.buttonFetchRecipes);
        buttonFetchRecipes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonFetchRecipes:
                Intent intent = new Intent(MainActivity.this, FetchRecipes.class);
                startActivity(intent);
                break;
        }
    }
}