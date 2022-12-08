package com.example.recipefetcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button  buttonShowItemList, buttonShowLocation;
    FloatingActionButton buttonAddItems;
    private ShoppingListViewModel shoppingListViewModel;
    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_EDIT = 2;
    private ShoppingListAdapter shoppingListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.shoppingListRecyclerView);
        shoppingListAdapter = new ShoppingListAdapter(this);
        recyclerView.setAdapter(shoppingListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddItems = (FloatingActionButton) findViewById(R.id.buttonAddItems);
        //buttonShowItemList = (Button) findViewById(R.id.buttonShowItemList);
        //buttonShowLocation = (Button) findViewById(R.id.buttonShowLocation);
        buttonAddItems.setOnClickListener(this);
        //buttonShowItemList.setOnClickListener(this);
       // buttonShowLocation.setOnClickListener(this);
        shoppingListViewModel = new ViewModelProvider(this).get(ShoppingListViewModel.class);
        shoppingListViewModel.getAllItems().observe(this, new Observer<List<ShoppingListItem>>() {
            @Override
            public void onChanged(List<ShoppingListItem> shoppingListItems) {
                shoppingListAdapter.setItems(shoppingListItems);
            }
        });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddItems:
                Intent intent = new Intent(MainActivity.this, AddItems.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
                break;


        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == RESULT_OK  && requestCode == REQUEST_CODE_ADD) {

            //final int id = Integer.parseInt(UUID.randomUUID().toString());
            String item = intent.getStringExtra(AddItems.NEW_ITEM);
            String amount = intent.getStringExtra(AddItems.NEW_AMOUNT);
            ShoppingListItem shoppingListItem = new ShoppingListItem(item, amount);
            shoppingListViewModel.insert(shoppingListItem);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.saved,
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.not_saved,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}