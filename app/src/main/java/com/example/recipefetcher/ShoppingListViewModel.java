package com.example.recipefetcher;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import android.os.AsyncTask;

import java.util.List;

public class ShoppingListViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private static Dao dao;
    private ShoppingListDatabase slDB;
    private LiveData<List<ShoppingListItem>> allItems;

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        slDB = ShoppingListDatabase.getDatabase(application);
        dao = slDB.Dao();
        allItems = dao.getAllItems();

    }

    LiveData<List<ShoppingListItem>> getAllItems() {
        return allItems;
    }

    public void insert(ShoppingListItem shoppingListItem) {
        new InsertShoppingListAsyncTask(dao).execute(shoppingListItem);
    }

    public void update(ShoppingListItem shoppingListItem) {
        new UpdateShoppingListAsyncTask(dao).execute(shoppingListItem);
    }

    public void delete(ShoppingListItem shoppingListItem) {
        new DeleteShoppingListAsyncTask(dao).execute(shoppingListItem);
    }

    private class InsertShoppingListAsyncTask extends AsyncTask<ShoppingListItem, Void, Void> {
        Dao dao;

        public InsertShoppingListAsyncTask(Dao dao) {
            this.dao = dao;
        }

        protected Void doInBackground(ShoppingListItem... shoppingListItems) {
            dao.insert(shoppingListItems[0]);
            return null;
        }
    }

    private class UpdateShoppingListAsyncTask extends AsyncTask<ShoppingListItem, Void, Void> {
        Dao dao;

        public UpdateShoppingListAsyncTask(Dao dao) {
            this.dao = dao;
        }

        protected Void doInBackground(ShoppingListItem... shoppingListItems) {
            dao.update(shoppingListItems[0]);
            return null;
        }
    }

    private class DeleteShoppingListAsyncTask extends AsyncTask<ShoppingListItem, Void, Void> {
        Dao dao;

        public DeleteShoppingListAsyncTask(Dao dao) {
            this.dao = dao;
        }

        protected Void doInBackground(ShoppingListItem... shoppingListItems) {
            dao.delete(shoppingListItems[0]);
            return null;
        }
    }
}
