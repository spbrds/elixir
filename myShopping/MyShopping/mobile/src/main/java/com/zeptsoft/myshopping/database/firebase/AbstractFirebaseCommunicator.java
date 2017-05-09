package com.zeptsoft.myshopping.database.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SSBook on 07/05/17.
 */

public abstract class AbstractFirebaseCommunicator {
    protected DatabaseReference databaseReference;

    protected abstract String getRootIdentifier();

    public AbstractFirebaseCommunicator(){
        this.databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    protected String getNewObjectKey(){
       return this.databaseReference.child(getRootIdentifier()).push().getKey();
    }


}
