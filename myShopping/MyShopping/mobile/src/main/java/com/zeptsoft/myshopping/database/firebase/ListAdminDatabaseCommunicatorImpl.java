package com.zeptsoft.myshopping.database.firebase;

import com.google.firebase.database.Query;
import com.zeptsoft.myshopping.database.interfaces.IListAdminDatabaseCommunicator;
import com.zeptsoft.myshopping.datatypes.ShopList;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SSBook on 16/05/17.
 */

public class ListAdminDatabaseCommunicatorImpl extends  AbstractFirebaseCommunicator implements IListAdminDatabaseCommunicator{

    private static final String rootNode = "lists";
    private static final String USER_ID_SEARCH_FIELD = "createUserId";

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
    public List<ShopList> getLists(String userId) {
        ArrayList<ShopList> list = new ArrayList<ShopList>();

        Query query = databaseReference.orderByChild(USER_ID_SEARCH_FIELD).equalTo(AuthenticationUtils.getAuthenticatedUser().getUid());
        //query

        return list;
    }


    @Override
    protected String getRootIdentifier() {
        return rootNode;
    }
}
