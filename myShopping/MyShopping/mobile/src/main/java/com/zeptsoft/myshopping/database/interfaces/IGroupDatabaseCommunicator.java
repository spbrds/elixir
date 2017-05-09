package com.zeptsoft.myshopping.database.interfaces;

import com.zeptsoft.myshopping.datatypes.Group;
import com.zeptsoft.myshopping.datatypes.ShopList;
import com.zeptsoft.myshopping.datatypes.User;

import java.util.List;

/**
 * Created by SSBook on 03/05/17.
 */

public interface IGroupDatabaseCommunicator {

    Group getGroup(String groupId);
    void createGroup(Group group);
    void updateGroup(String groupId, String name);

    List<ShopList> getLists(String groupId);
    void addList (String groupId, String listId, String listName);
    void removeList(String groupId, String listId);

    List<User> getUsers(String groupId);
    void addUser(String groupId, String userId, String userName);
    void removeUser(String groupId, String userId);



}
