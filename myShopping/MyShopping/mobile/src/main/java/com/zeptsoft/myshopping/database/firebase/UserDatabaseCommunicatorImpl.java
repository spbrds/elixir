package com.zeptsoft.myshopping.database.firebase;

import com.zeptsoft.myshopping.database.interfaces.IUserDatabaseCommunicator;
import com.zeptsoft.myshopping.datatypes.PendingInvite;
import com.zeptsoft.myshopping.datatypes.User;

import java.util.HashMap;

/**
 * Created by SSBook on 04/05/17.
 */

public class UserDatabaseCommunicatorImpl extends AbstractFirebaseCommunicator implements IUserDatabaseCommunicator{

    private static final String rootNode = "users";

    @Override
    protected String getRootIdentifier() {
        return rootNode;
    }

    public UserDatabaseCommunicatorImpl(){
        super();
    }

    @Override
    public void createUser(User user) {
        user.setId(this.getNewObjectKey());
        HashMap<String,Object> childData = new HashMap<>();
        childData.put(String.format("/%1$s/%2$s",this.getRootIdentifier(),user.getId()),user.toMap());
        databaseReference.updateChildren(childData);

    }

    @Override
    public void updateUser(User user) {
        HashMap<String,Object> childData = new HashMap<>();
        childData.put(String.format("/%1$s/%2$s",this.getRootIdentifier(),user.getId()),user.toMap());
        databaseReference.updateChildren(childData);
    }

    @Override
    public void removeUser(String userId) {

    }

    @Override
    public User getUser(String userId) {
        return null;
    }

    @Override
    public void removeInvite(String userId, String inviteId) {

    }

    @Override
    public void addInvite(String userId, PendingInvite invite) {

    }

    @Override
    public void addGroup(String userId, String groupId, String groupName) {

    }

    @Override
    public void removeGroup(String userId, String groupId) {

    }
}
