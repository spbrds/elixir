package com.zeptsoft.myshopping.database.interfaces;

import com.zeptsoft.myshopping.datatypes.ShopList;

import java.util.List;

/**
 * Created by SSBook on 16/05/17.
 */

public interface IListAdminDatabaseCommunicator {
    void create(ShopList list);
    void delete(String listId);
    void updateInfo(ShopList list);
    List<ShopList> getLists(String userId);
}
