package com.zeptsoft.myshopping.core.listmanager;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 21/03/17.
 */

public class MockListManager extends ListManager {

    @Override
    public List<Item> getList() {


        return null;
    }



    private List<Item> buildDefaultMockList(){
        List<Item> items = new ArrayList<>();
        Item item = new Item();


        return items;
    }

    private void addDummySecondaryInfo(Item i){
        i.setUrgent(false);
        i.setChecked(false);
        i.setCreateUserId("mocker");
    }
}
