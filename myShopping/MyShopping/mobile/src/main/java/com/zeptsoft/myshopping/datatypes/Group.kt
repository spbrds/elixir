package com.zeptsoft.myshopping.datatypes

import com.zeptsoft.myshopping.datatypes.interfaces.IMapable

/**
 * Created by SSBook on 06/06/17.
*/

data class Group (var id : String, var name : String, var users : List<User>, var shopLists : List<ShopList> ){


    fun toMap() : Map<String, Any>{
        val res = HashMap<String, Any>()

        res["id"] = id;
        res["name"] = name;
        res["users"] = users;
        res["shopLists"] = shopLists;

        return res
    }
}




