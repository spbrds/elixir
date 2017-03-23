package com.zeptsoft.myshopping.core.listplayer;

import com.zeptsoft.myshopping.core.listmanager.IListManager;
import com.zeptsoft.myshopping.datatypes.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 16/03/17.
 */

public class SimpleListNavigator implements IListNavigator {
    private String listId;
    private IListManager manager;
    private List<Item> items;
    private List<Integer> indexes;
    private int currentIndex = 0;

    public Item getFirst(){
        return items.isEmpty() ? null : items.get(0);
    }

    @Override
    public Item next() {
        //checking if list is already empty
        if(indexes.isEmpty()){
            return null;
        }

        currentIndex = this.hasNext() ? currentIndex + 1 : 0;
        return items.get(indexes.get(currentIndex));
    }

    @Override
    public Item previous() {
        //checking if list is already empty
        if(indexes.isEmpty()){
            return null;
        }
        currentIndex = this.hasPrevious() ? currentIndex - 1 : items.size()-1;
        return items.get(indexes.get(currentIndex));
    }

    @Override
    public void check() {
        if(indexes.isEmpty()){
            return;
        }
        this.manager.checkItem(items.get(indexes.get(currentIndex)).getName());
        this.indexes.remove(currentIndex);

    }

    @Override
    public void startNavigation(IListManager manager, String id) {
        this.listId = id;
        this.manager = manager;
        this.items = manager.getList();

        initIndexesArray();
    }

    private void initIndexesArray(){
        this.indexes = new ArrayList<>();
        int listSize = items.size();

        for (int i = 0; i < listSize; i++){
            indexes.add(i);
        }
    }

    private boolean hasNext(){
        return !((currentIndex + 1) >= indexes.size());

    }

    private boolean hasPrevious(){
        return !((currentIndex) <= 0);
    }
}
