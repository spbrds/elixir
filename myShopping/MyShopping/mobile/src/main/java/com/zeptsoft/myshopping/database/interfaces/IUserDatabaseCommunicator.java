package com.zeptsoft.myshopping.database.interfaces;

import com.zeptsoft.myshopping.datatypes.PendingInvite;
import com.zeptsoft.myshopping.datatypes.User;

/**
 * Created by SSBook on 03/05/17.
 */

public interface IUserDatabaseCommunicator {
    void createUser(User user);
    void updateUser(User user);
    void removeUser(String userId);
    User getUser(String userId);

    void removeInvite(String userId, String inviteId);
    void addInvite(String userId, PendingInvite invite);

    //void getGroups(String userId)
    void addGroup(String userId, String groupId, String groupName);
    void removeGroup(String userId, String groupId);

}
