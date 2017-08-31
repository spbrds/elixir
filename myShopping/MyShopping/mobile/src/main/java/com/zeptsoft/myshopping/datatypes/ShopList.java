package com.zeptsoft.myshopping.datatypes;

import com.google.firebase.database.Exclude;
import com.zeptsoft.myshopping.datatypes.interfaces.IMapable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SSBook on 15/03/17.

public class ShopList implements IMapable{
    private String id;
    private String name;
    private String groupId;
    private boolean personal;
    private String createUserId;
    private Date updatingDate;
    private List<Item> items;


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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String familyId) {
        this.groupId = groupId;
    }

    public boolean isPersonal() {
        return personal;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdatingDate() {
        return updatingDate;
    }

    public void setUpdatingDate(Date updatingDate) {
        this.updatingDate = updatingDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Exclude
    public Map<String,Object> toMap(){
        Map<String, Object> map = new HashMap<>();

        map.put("id",this.id);
        map.put("name",this.name);
        map.put("groupId",this.groupId);
        map.put("personal",this.personal);
        map.put("createUserId",this.createUserId);
        map.put("updatingDate",this.updatingDate);
        map.put("items",this.items);

        return map;
    }
}
 */