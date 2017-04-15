package com.zeptsoft.myshopping.core.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.datatypes.Item;

/**
 * Created by SSBook on 30/03/17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private SelectableItem selectableItem;
    private TextView name;
    private TextView category;
    private TextView observations;
    private ImageView checkedImage;
    private CheckBox selectCheckBox;

    public ItemViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.item_name);
        category = (TextView)itemView.findViewById(R.id.item_category);
        observations = (TextView)itemView.findViewById(R.id.item_observations);
        checkedImage = (ImageView)itemView.findViewById(R.id.item_check_image);
        selectCheckBox = (CheckBox)itemView.findViewById(R.id.item_checkbox);
    }

    public void bindItem(SelectableItem si){
        this.selectableItem = si;
        Item i = si.getItem();
        name.setText(i.getName());
        category.setText(i.getCategory());
        observations.setText(i.getObservations());
        checkedImage.setVisibility(i.isChecked() ? View.VISIBLE : View.INVISIBLE);
        selectCheckBox.setChecked(si.isSelected());

        //binding the checkbox
        selectCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                selectableItem.getItem().setChecked(isChecked);
            }
        });

    }

}
