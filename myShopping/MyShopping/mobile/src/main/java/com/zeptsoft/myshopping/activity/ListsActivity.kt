package com.zeptsoft.myshopping.activity

import android.support.v4.app.Fragment
import com.zeptsoft.myshopping.core.activity.SingleFragmentActivity
import com.zeptsoft.myshopping.core.fragments.ListListFragment
import com.zeptsoft.myshopping.core.fragments.ListsFragment

/**
 * Created by SSBook on 06/09/17.
 */

class ListsActivity : SingleFragmentActivity(){
    override fun getFragmentInstance(): Fragment {
       return ListsFragment.getInstance();
    }

}