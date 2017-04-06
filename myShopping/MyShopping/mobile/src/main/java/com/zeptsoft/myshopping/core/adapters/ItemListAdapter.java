package com.zeptsoft.myshopping.core.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 30/03/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private List<Item> items;

    public ItemListAdapter(Context context, List<Item> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(this.context).inflate(R.layout.item_list_layout, parent, false);
        return new ItemViewHolder(holderView);
    }


    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

}
