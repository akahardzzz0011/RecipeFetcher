package com.example.recipefetcher;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class EditItemViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private Dao dao;
    private ShoppingListDatabase db;

    public EditItemViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "Editing");
        db = ShoppingListDatabase.getDatabase(application);
        dao = db.Dao();
    }
    public LiveData<ShoppingListItem> getItem(String itemId) {
        return dao.getItem(itemId);
    }
}
