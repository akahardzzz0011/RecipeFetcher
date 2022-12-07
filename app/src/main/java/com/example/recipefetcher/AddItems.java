package com.example.recipefetcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddItems extends AppCompatActivity {

    public static final String NEW_ITEM = "new_item", NEW_AMOUNT = "amount";

    private EditText newItem, newAmount;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        buttonSave = (Button)findViewById(R.id.buttonSave);
        newItem = (EditText) findViewById(R.id.editTextShoppingListItem);
        newAmount = (EditText) findViewById(R.id.editTextAmount);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String itemValue = newItem.getText().toString();
                String amountValue = newAmount.getText().toString();

                if (TextUtils.isEmpty(newItem.getText())) {
                    setResult(RESULT_CANCELED, intent);
                } else {
                    intent.putExtra(NEW_ITEM, itemValue);
                    intent.putExtra(NEW_AMOUNT, amountValue);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}