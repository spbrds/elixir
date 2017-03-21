package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 20/03/17.
 */

public interface IListManager {
    public List<Item> getList();
    public void addItem(Item item);
    public void deleteItem(String itemId);
    public void editItem(String itemId, Item item);
    public Item getItem(String itemId);
    public void checkItem(String itemId);
    public void deleteList();

    public void commit();
    public void rollback();

}
