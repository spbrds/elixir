package com.zeptsoft.myshopping.core.listmanager;

/**
 * Created by SSBook on 30/03/17.
 */

public interface IListSubject {

    void register(IListObserver observer);
    void notifyObservers();
    void unregister(IListObserver observer);
}
