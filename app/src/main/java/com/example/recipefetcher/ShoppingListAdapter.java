package com.example.recipefetcher;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<ShoppingListItem> shoppingList;

    public ShoppingListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }
    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        ShoppingListViewHolder shoppingListViewHolder = new ShoppingListViewHolder(itemView);
        return shoppingListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.ShoppingListViewHolder holder, int position) {
        if (shoppingList != null) {
            ShoppingListItem shoppingListItem = shoppingList.get(position);
            holder.setData(shoppingListItem.getItem(), shoppingListItem.getAmount(), position);
        } else {
            holder.slItemView.setText(R.string.no_items);
        }
    }

    @Override
    public int getItemCount() {
        if(shoppingList != null) {
            return shoppingList.size();
        } else {
            return 0;
        }
    }

    public void setItems(List<ShoppingListItem> shoppingListItems) {
        shoppingList = shoppingListItems;
        notifyDataSetChanged();
    }

    public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        private TextView slItemView, amountView;
        private int tempPosition;

        public ShoppingListViewHolder(View itemView) {
            super(itemView);
            slItemView = itemView.findViewById(R.id.textShoppingListItem);
            amountView = itemView.findViewById(R.id.textAmount);
        }

        public void setData(String item, String amount, int position) {
            slItemView.setText(item);
            amountView.setText(amount);
            tempPosition = position;
        }
    }
}
