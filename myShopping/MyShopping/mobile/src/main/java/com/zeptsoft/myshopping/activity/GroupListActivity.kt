package com.zeptsoft.myshopping.activity

import android.support.v4.app.Fragment
import com.zeptsoft.myshopping.core.activity.SingleFragmentActivity
import com.zeptsoft.myshopping.core.fragments.GroupListFragment

/**
 * Created by SSBook on 27/09/17.
 */

class GroupListActivity : SingleFragmentActivity(){
    override fun getFragmentInstance() : Fragment  = GroupListFragment.getInstance();

}