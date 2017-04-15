package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.core.adapters.SelectableItem;
import com.zeptsoft.myshopping.datatypes.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 09/03/17.
 */

public class ListManager implements IListManager, IListSubject{

    protected String listId;
    protected List<SelectableItem> items = new ArrayList<>();

    public ListManager(String listId){
        this.listId = listId;
    }

    @Override
    public List<SelectableItem> getList() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        SelectableItem selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        items.add(selectableItem);
    }

    @Override
    public void deleteItem(String itemId) {
        if(itemId == null){
            return;
        }

        SelectableItem item = findItem(itemId);

        if (item != null) {
            this.items.remove(item);
        }

    }

    @Override
    public void editItem(String itemId, Item item) {

    }

    @Override
    public Item getItem(String itemId) {
        if(itemId == null){
            return null;
        }

        SelectableItem item = findItem(itemId);

        return item != null? item.getItem() : null;
    }

    @Override
    public void checkItem(String itemId) {
        if(itemId == null){
            return;
        }
        //maybe just do a update on the database and then wait for the callback to update the manager
        //checking the item
        SelectableItem item = findItem(itemId);

        if(item != null) {
            item.getItem().setChecked(true);
        }

        //update on DB
    }

    @Override
    public void deleteList() {

    }

    @Override
    public void checkSelectedItems() {
        for(SelectableItem si : items){
            if(si.isSelected()){
                si.getItem().setChecked(true);
            }
        }
    }

    @Override
    public void deleteSelectedItems() {
        ArrayList<SelectableItem> deletedItems = new ArrayList<>();

        for(SelectableItem si : items){
            if(si.isSelected()){
                deletedItems.add(si);
            }
        }

        for(SelectableItem si : deletedItems){
            this.items.remove(si);
        }
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

    private SelectableItem findItem(String itemId){
        for(SelectableItem selectable : items){
            if(itemId.equals(selectable.getItem().getName())){
                return selectable;
            }
        }

        return null;
    }
}
