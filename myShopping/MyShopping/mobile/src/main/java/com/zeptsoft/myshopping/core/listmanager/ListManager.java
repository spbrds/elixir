package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 09/03/17.
 */

public class ListManager implements IListManager, IListSubject{

    protected String listId;
    protected List<Item> items;

    public ListManager(String listId){
        this.listId = listId;
    }

    @Override
    public List<Item> getList() {
        return null;
    }

    @Override
    public void addItem(Item item) {

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
