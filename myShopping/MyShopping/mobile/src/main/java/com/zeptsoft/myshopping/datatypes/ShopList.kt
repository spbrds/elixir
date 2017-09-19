package com.zeptsoft.myshopping.datatypes

import java.util.*
import kotlin.collections.HashMap

/**
 * Created by SSBook on 06/06/17.
*/

data class ShopList (var id : String? = "", var name : String? = "",
                     var groupId : String? = "", var personal : Boolean? = false,
                     var createUserId : String? = "", var updatingDate : Date?,
                     var items : MutableList<Item>){

    fun toMap() : Map<String, Any?>{
        val res = HashMap<String, Any?>();

        res["id"] = id;
        res["name"] = name;
        res["groupId"] = groupId;
        res["personal"] = personal;
        res["createUserId"] = createUserId;
        res["updatingDate"] = updatingDate;
        res["items"] = items;

        return res;
    }
}