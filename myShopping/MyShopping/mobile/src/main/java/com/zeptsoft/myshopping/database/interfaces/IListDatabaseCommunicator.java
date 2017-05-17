package com.zeptsoft.myshopping.database.interfaces;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 16/03/17.
 */

public interface IListDatabaseCommunicator {
    //getItem();
    void editItem(Item item);
    void writeItem(Item item);
    void deleteItem(Item item);
    void overrideAllList(List<Item> items);
}
