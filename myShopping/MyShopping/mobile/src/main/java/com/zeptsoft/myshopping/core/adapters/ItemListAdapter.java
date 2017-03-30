package com.zeptsoft.myshopping.core.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 30/03/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public List<Item> items;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
