package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.core.adapters.SelectableItem;
import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 20/03/17.
 */

public interface IListManager {
    List<SelectableItem> getList();
    void addItem(Item item);
    void deleteItem(String itemId);
    void editItem(String itemId, Item item);
    Item getItem(String itemId);
    void checkItem(String itemId);
    void deleteList();

    void checkSelectedItems();
    void deleteSelectedItems();

    void commit();
    void rollback();

}
