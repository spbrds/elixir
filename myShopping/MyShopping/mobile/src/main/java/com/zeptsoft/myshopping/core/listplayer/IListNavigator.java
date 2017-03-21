package com.zeptsoft.myshopping.core.listplayer;

import com.zeptsoft.myshopping.datatypes.Item;

import java.util.List;

/**
 * Created by SSBook on 16/03/17.
 */

public interface IListNavigator {
    public Item next();
    public Item previous();
    public void check();
    public void startNavigation(List<Item> list, String id);


}
