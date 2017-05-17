package com.zeptsoft.myshopping.database.firebase;

import com.zeptsoft.myshopping.database.interfaces.IListAdminDatabaseCommunicator;
import com.zeptsoft.myshopping.datatypes.ShopList;

import java.util.HashMap;

/**
 * Created by SSBook on 16/05/17.
 */

public class ListAdminDatabaseCommunicatorImpl extends  AbstractFirebaseCommunicator implements IListAdminDatabaseCommunicator{

    private static final String rootNode = "lists";

    @Override
    //TODO: generalizar isto
    public void create(ShopList list) {
        list.setId(this.getNewObjectKey());
        HashMap<String, Object> childData = new HashMap<>();
        childData.put(String.format("/%s/%s", this.getRootIdentifier(), list.getId()), list.toMap());
        databaseReference.updateChildren(childData);
    }

    @Override
    public void delete(String listId) {

    }

    @Override
    public void updateInfo(ShopList list) {

    }

    @Override
    protected String getRootIdentifier() {
        return rootNode;
    }
}
