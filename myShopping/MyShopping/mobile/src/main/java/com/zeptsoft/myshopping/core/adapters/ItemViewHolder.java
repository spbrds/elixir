package com.zeptsoft.myshopping.core.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.datatypes.Item;

/**
 * Created by SSBook on 30/03/17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private Item item;
    private TextView name;
    private TextView category;
    private TextView observations;
    private ImageView checkedImage;

    public ItemViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.item_name);
        category = (TextView)itemView.findViewById(R.id.item_category);
        observations = (TextView)itemView.findViewById(R.id.item_observations);
        checkedImage = (ImageView)itemView.findViewById(R.id.item_check_image);
    }

    public void bindItem(Item i){
        item = i;
        name.setText(i.getName());
        category.setText(i.getCategory());
        observations.setText(i.getObservations());
        checkedImage.setVisibility(i.isChecked() ? View.VISIBLE : View.INVISIBLE);

    }

}
