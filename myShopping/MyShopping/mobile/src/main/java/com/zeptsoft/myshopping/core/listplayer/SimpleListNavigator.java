package com.zeptsoft.myshopping.core.listplayer;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by SSBook on 16/03/17.
 */

public class SimpleListNavigator implements IListNavigator {
    private String listId;
    private List<Item> items;
    private int currentIndex = 0;

    @Override
    public Item next() {
        currentIndex = this.hasNext() ? currentIndex + 1 : 0;
        return items.get(currentIndex);
    }

    @Override
    public Item previous() {
        currentIndex = this.hasPrevious() ? currentIndex - 1 : items.size()-1;
        return items.get(currentIndex);
    }

    @Override
    public void check() {

    }

    @Override
    public void startNavigation(List<Item> list, String id) {
        this.listId = id;
        this.items = list;
    }

    private boolean hasNext(){
        return !((currentIndex + 1) >= items.size());

    }

    private boolean hasPrevious(){
        return !((currentIndex) <= 0);
    }
}
