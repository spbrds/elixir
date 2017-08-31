package com.zeptsoft.myshopping.datatypes;


import com.google.firebase.database.Exclude;
import com.zeptsoft.myshopping.datatypes.interfaces.IMapable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SSBook on 03/05/17.
 *

public class User implements IMapable {

    private String id;
    private String name;
    private String email;
    private Date lastLogin;
    private List<PendingInvite> pendingInvites;
    private List<Group> groups;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<PendingInvite> getPendingInvites() {
        return pendingInvites;
    }

    public void setPendingInvites(List<PendingInvite> pendingInvites) {
        this.pendingInvites = pendingInvites;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Exclude
    @Override
    public Map<String, Object> toMap() {
        HashMap<String,Object> res = new HashMap<>();
        res.put("id", this.id);
        res.put("name", this.name);
        res.put("email", this.getEmail());
        res.put("lastLogin", this.lastLogin);
        res.put("pendingInvites", this.pendingInvites);
        res.put("groups", this.groups);

        return res;
    }

}
 **/
