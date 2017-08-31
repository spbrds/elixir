package com.zeptsoft.myshopping.datatypes;

import com.zeptsoft.myshopping.datatypes.interfaces.IMapables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SSBook on 03/05/17.


public class Group implements IMapables {
    private String id;
    private String name;
    private List<User> users;
    private List<ShopList> lists;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ShopList> getLists() {
        return lists;
    }

    public void setLists(List<ShopList> lists) {
        this.lists = lists;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("users", this.users);
        map.put("lists", this.lists);

        return map;
    }
}
 */