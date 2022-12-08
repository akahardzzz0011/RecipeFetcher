package com.example.recipefetcher;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import javax.annotation.Nullable;

public class EditItemActivity extends AppCompatActivity {

    private EditText editItem, editAmount;
    private Bundle bundle;
    private String itemId;
    private LiveData<ShoppingListItem> shoppingListItem;
    EditItemViewModel itemViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editItem = findViewById(R.id.textItemEdit);
        editAmount = findViewById(R.id.textAmountEdit);
        bundle = getIntent().getExtras();

        if(bundle != null) {
            itemId = bundle.getString("item_id");
        }

        itemViewModel = new ViewModelProvider(this).get(EditItemViewModel.class);
        shoppingListItem = itemViewModel.getItem(itemId);
        shoppingListItem.observe(this, new Observer<ShoppingListItem>() {
            @Override
            public void onChanged(@Nullable ShoppingListItem listItem) {
                editItem.setText(listItem.getItem());
            }
        });
    }
}
