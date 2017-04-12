package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 09/03/17.
 */

public class ListManager implements IListManager, IListSubject{

    protected String listId;
    protected List<Item> items = new ArrayList<>();

    public ListManager(String listId){
        this.listId = listId;
    }

    @Override
    public List<Item> getList() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public void editItem(String itemId, Item item) {

    }

    @Override
    public Item getItem(String itemId) {
        return null;
    }

    @Override
    public void checkItem(String itemId) {
        if(itemId == null){
            return;
        }
//maybe just do a update on the database and then wait for the callback to update the manager
        //checking the item
        for(Item item : items){
            if(itemId.equals(item.getName())){
                item.setChecked(true);
                break;
            }
        }

        //update on DB
    }

    @Override
    public void deleteList() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void register(IListObserver observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void unregister(IListObserver observer) {

    }
}
