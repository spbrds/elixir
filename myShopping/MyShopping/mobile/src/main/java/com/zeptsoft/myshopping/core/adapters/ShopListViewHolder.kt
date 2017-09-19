package com.zeptsoft.myshopping.core.adapters

import com.zeptsoft.myshopping.R
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.zeptsoft.myshopping.datatypes.ShopList

/**
 * Created by SSBook on 15/09/17.
 */

class ShopListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


    private var listNameTextView : TextView;
    private var id : String = "";

    init{
        listNameTextView = itemView.findViewById(R.id.lists_name);

    }

    fun bindView(list : ShopList){
        id = list.id!!;
        listNameTextView.setText(list.name);
    }

}