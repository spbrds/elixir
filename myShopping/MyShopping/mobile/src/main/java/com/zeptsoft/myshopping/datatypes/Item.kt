package com.zeptsoft.myshopping.datatypes

/**
 * Created by SSBook on 06/06/17.
 */


data class Item(var id : String ? = "", var name : String ? = "",
                var category : String ? = "", var observations : String ? = "",
                var checked : Boolean ? = false, var urgent : Boolean? = false,
                var createUserId : String ? =""){

    fun toMap(): Map<String,Any?>{
        val res = HashMap<String, Any?>();

        res["name"] = name;
        res["id"] = id;
        res["category"] = category;
        res["observations"] = observations;
        res["checked"] = checked;
        res["urgent"] = urgent;
        res["createUserId"] = createUserId;

        return res;
    }
}
