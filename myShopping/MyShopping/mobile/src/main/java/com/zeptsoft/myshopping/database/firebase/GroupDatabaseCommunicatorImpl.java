package com.zeptsoft.myshopping.database.firebase;

import com.zeptsoft.myshopping.database.interfaces.IGroupDatabaseCommunicator;
import com.zeptsoft.myshopping.datatypes.Group;
import com.zeptsoft.myshopping.datatypes.ShopList;
import com.zeptsoft.myshopping.datatypes.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by SSBook on 04/05/17.
 */

public class GroupDatabaseCommunicatorImpl extends AbstractFirebaseCommunicator implements IGroupDatabaseCommunicator{

    public static final String rootNode = "groups";

    @Override
    protected String getRootIdentifier() {
        return rootNode;
    }

    @Override
    public Group getGroup(String groupId) {
        return null;
    }

    @Override
    public void createGroup(Group group) {
        HashMap<String,Object> childData = new HashMap<>();
        group.setId(getNewObjectKey());
        childData.put(String.format("/%1$s/%2$s",this.getRootIdentifier(),group.getId()),group.toMap());
        databaseReference.updateChildren(childData);
    }

    @Override
    public void updateGroup(String groupId, String name) {

    }

    @Override
    public List<ShopList> getLists(String groupId) {
        return null;
    }

    @Override
    public void addList(String groupId, String listId, String listName) {

    }

    @Override
    public void removeList(String groupId, String listId) {

    }

    @Override
    public List<User> getUsers(String groupId) {
        return null;
    }

    @Override
    public void addUser(String groupId, String userId, String userName) {

    }

    @Override
    public void removeUser(String groupId, String userId) {

    }
}
