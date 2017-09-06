package com.zeptsoft.myshopping.core.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zeptsoft.myshopping.R
import com.zeptsoft.myshopping.core.ui.AddButtonAnimator

/**
 * Created by SSBook on 06/09/17.
 */

class ListsFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view: View = inflater?.inflate(R.layout.list_list_fragment_layout, container, false)!!;
        initLayout(view);

        return view;
    }

    private fun initLayout(view:View){

    }

    public fun getInstance() = ListsFragment()

}
