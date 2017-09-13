package com.zeptsoft.myshopping.core.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.zeptsoft.myshopping.R
import com.zeptsoft.myshopping.core.ui.AddButtonAnimator
import com.zeptsoft.myshopping.datatypes.Item
import com.zeptsoft.myshopping.datatypes.ShopList
import com.zeptsoft.myshopping.log.LogUtils
import java.util.*

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
        val addButton : FloatingActionButton = view.findViewById(R.id.list_add_button);
        val addLayout : View = view.findViewById(R.id.add_list_layout);
        val animator  =  AddButtonAnimator(this.context, addLayout, addButton);

        //new list button to unhide the add layout
        addButton.setOnClickListener(View.OnClickListener {
            animator.animateLayout();
        });

        //add button to create a new list
        view.findViewById<View>(R.id.list_add_button_ok).setOnClickListener(View.OnClickListener {
            val shopList = getListFromForm(view);
            LogUtils.d(shopList.toString());
        });

    }

    companion object {
        fun getInstance(): ListsFragment = ListsFragment();
    }


    private fun getListFromForm(view : View) : ShopList{
        val name = view.findViewById<EditText>(R.id.new_list_name).text.toString();
        val private = view.findViewById<CheckBox>(R.id.new_list_private).isChecked;
        val group = ""+view.findViewById<Spinner>(R.id.new_list_group_spinner).selectedItemPosition;

        return ShopList(name = name, groupId = group, personal = private, items = emptyList(), updatingDate = Date());
    }


}
