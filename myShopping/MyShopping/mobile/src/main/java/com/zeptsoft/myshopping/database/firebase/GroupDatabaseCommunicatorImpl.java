package com.zeptsoft.myshopping.database.firebase;

/**
 * Created by SSBook on 04/05/17.
 */

public class GroupDatabaseCommunicatorImpl extends AbstractFirebaseCommunicator{

    public static final String rootNode = "groups";

    @Override
    protected String getRootIdentifier() {
        return rootNode;
    }
}
