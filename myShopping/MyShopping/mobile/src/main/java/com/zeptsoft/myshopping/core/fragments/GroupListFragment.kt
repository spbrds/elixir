package com.zeptsoft.myshopping.core.fragments

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zeptsoft.myshopping.R
import com.zeptsoft.myshopping.core.ui.AddButtonAnimator
import com.zeptsoft.myshopping.database.firebase.GroupDatabaseCommunicatorImpl

/**
 * Created by SSBook on 27/09/17.
 */

class GroupListFragment : Fragment(){

    private lateinit var recyclerView : RecyclerView;
    private lateinit var listAdapter : Any;
    private lateinit var animator : AddButtonAnimator;
    private val groupDatabaseCommunicator = GroupDatabaseCommunicatorImpl();


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.group_list_fragment_layout,container,false)!!
        initLayout(view)
        return view
    }

    private fun initLayout(view : View){
        //init add button
        val addButton : FloatingActionButton = view.findViewById(R.id.list_add_button);
        val addLayout :View =  view.findViewById(R.id.add_group_layout);
        this.animator = AddButtonAnimator(this.context,view,addLayout);

        addButton.setOnClickListener(View.OnClickListener {
            animator.animateLayout();
        });

        //setting add Button action



    }

    companion object {
        fun getInstance() : GroupListFragment = GroupListFragment()
    }


}