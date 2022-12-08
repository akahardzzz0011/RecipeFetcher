package com.example.recipefetcher;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
            holder.setListeners();
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
        private ImageView imageEditView, imageDeleteView;

        public ShoppingListViewHolder(View itemView) {
            super(itemView);
            slItemView = itemView.findViewById(R.id.textShoppingListItem);
            amountView = itemView.findViewById(R.id.textAmount);
            imageDeleteView = itemView.findViewById(R.id.imageItemDelete);
            imageEditView = itemView.findViewById(R.id.imageItemEdit);
        }

        public void setData(String item, String amount, int position) {
            slItemView.setText(item);
            amountView.setText(amount);
            tempPosition = position;
        }

        public void setListeners() {
            imageEditView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, EditItemActivity.class);
                    intent.putExtra("item_id", shoppingList.get(tempPosition).getId());
                    ((Activity)mContext).startActivityForResult(intent, MainActivity.REQUEST_CODE_EDIT);
                }
            });

            imageDeleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
