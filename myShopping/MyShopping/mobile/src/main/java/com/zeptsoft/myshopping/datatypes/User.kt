package com.zeptsoft.myshopping.datatypes

import java.util.*
import kotlin.collections.HashMap

/**
 * Created by SSBook on 06/06/17.
**/

data class User (var id : String? = "", val name : String = "",
                 val email : String = "", val lastLogin : Date?,
                 val pendingInvites : List<String>?, val groups : List<String>?,
                 val privateLists : List<ShopList>){


    fun toMap() : Map<String, Any?>{
        val res = HashMap<String, Any?>();

        res["id"] = id;
        res["name"] = name;
        res["email"] = email;
        res["lastLogin"] = lastLogin;
        res["pendingInvites"] = pendingInvites;
        res["groups"] = groups;

        return res;
    }
}

