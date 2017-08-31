package com.zeptsoft.myshopping.datatypes

/**
 * Created by SSBook on 06/06/17.
 */

data class PendingInvite(
        var id : String ? = "", var invitedUserId : String = "",
        var invitingUserId : String? = "", var invitingUserName : String? = "",
        var groupId : String? = "", var groupName : String? = ""){


    fun toMap() : Map<String, Any?>{
        val res = HashMap<String, Any?>();

        res["id"] = id;
        res["invitedUserId"] = invitedUserId;
        res["invitingUserId"] = invitingUserId;
        res["invitingUserName"] = invitingUserName;
        res["groupId"] = groupId;
        res["groupName"] = groupName;

        return res;
    }
}

