package com.zeptsoft.myshopping.core.adapters;

import com.zeptsoft.myshopping.datatypes.Item;

/**
 * Created by SSBook on 15/04/17.
 */

public class SelectableItem {
    private Item item;
    private boolean selected;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
