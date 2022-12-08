package com.example.recipefetcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.View;

import javax.annotation.Nullable;

public class EditItemActivity extends AppCompatActivity {

    public static final String ITEM_ID = "item_id";
    static final String UPDATED_ITEM = "item_name";
    static final String UPDATED_AMOUNT = "item_amount";
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
                editAmount.setText(listItem.getAmount());
            }
        });
    }
    public void updateItem(View view) {
        String updatedItem = editItem.getText().toString();
        String updatedAmount = editAmount.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(ITEM_ID, itemId);
        intent.putExtra(UPDATED_ITEM, updatedItem);
        intent.putExtra(UPDATED_AMOUNT, updatedAmount);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelUpdate(View view) {
        finish();
    }
}
