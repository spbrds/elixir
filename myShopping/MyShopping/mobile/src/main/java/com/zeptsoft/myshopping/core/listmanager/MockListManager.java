package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.core.adapters.SelectableItem;
import com.zeptsoft.myshopping.datatypes.Item;
import com.zeptsoft.myshopping.log.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 21/03/17.
 */

public class MockListManager extends ListManager {

    public MockListManager() {
        super("mockedlist");
    }

    @Override
    public List<SelectableItem> getList() {
        this.items = buildDefaultMockList();
        return items;
    }

    @Override
    public void checkItem(String itemId){
        LogUtils.d("Checked item: "+itemId);
    }

    private List<SelectableItem> buildDefaultMockList(){
        List<SelectableItem> items = new ArrayList<>();
        SelectableItem selectableItem = new SelectableItem();
        Item item = new Item();

        selectableItem.setItem(item);
        item.setName("Queijo");
        item.setCategory("Cat 1");
        item.setObservations(null);
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        item = new Item();
        selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        item.setName("Fiambre");
        item.setCategory("Cat 1");
        item.setObservations(null);
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        item = new Item();
        selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        item.setName("Pão");
        item.setCategory("Cat 1");
        item.setObservations("Comprar fatiado");
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        item = new Item();
        selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        item.setName("Farinha");
        item.setCategory("Cat 2");
        item.setObservations(null);
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        item = new Item();
        selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        item.setName("Chouriço");
        item.setCategory("Cat 1");
        item.setObservations(null);
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        item = new Item();
        selectableItem = new SelectableItem();
        selectableItem.setItem(item);
        item.setName("Peixe");
        item.setCategory("Cat 1");
        item.setObservations("Trazer pescada");
        addDummySecondaryInfo(item);
        items.add(selectableItem);

        return items;
    }

    private void addDummySecondaryInfo(Item i){
        i.setUrgent(false);
        i.setChecked(false);
        i.setCreateUserId("mocker");
    }
}
