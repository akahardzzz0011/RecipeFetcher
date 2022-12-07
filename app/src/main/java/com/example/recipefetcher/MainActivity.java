package com.example.recipefetcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddItems, buttonShowItemList, buttonShowLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddItems = (Button) findViewById(R.id.buttonAddItems);
        buttonShowItemList = (Button) findViewById(R.id.buttonShowItemList);
        buttonShowLocation = (Button) findViewById(R.id.buttonShowLocation);
        buttonAddItems.setOnClickListener(this);
        buttonShowItemList.setOnClickListener(this);
        buttonShowLocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddItems:
                Intent intent = new Intent(MainActivity.this, AddItems.class);
                startActivity(intent);
                break;


        }
    }
}