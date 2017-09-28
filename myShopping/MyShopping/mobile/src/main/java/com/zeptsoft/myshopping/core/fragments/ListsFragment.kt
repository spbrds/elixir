package com.zeptsoft.myshopping.core.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import com.zeptsoft.myshopping.R
import com.zeptsoft.myshopping.core.adapters.ListsAdapter
import com.zeptsoft.myshopping.core.ui.AddButtonAnimator
import com.zeptsoft.myshopping.database.firebase.ListAdminDatabaseCommunicatorImpl
import com.zeptsoft.myshopping.database.interfaces.IListAdminDatabaseCommunicator
import com.zeptsoft.myshopping.datatypes.ShopList
import com.zeptsoft.myshopping.log.LogUtils
import com.zeptsoft.myshopping.utils.AuthenticationUtils
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by SSBook on 06/09/17.
 */

class ListsFragment : Fragment(){

    private lateinit var recyclerView : RecyclerView;
    private lateinit var listAdapter : ListsAdapter;
    private val listList : MutableList<ShopList> = ArrayList<ShopList>();
    private lateinit var animator : AddButtonAnimator;
    private val listDatabaseCommunicator : IListAdminDatabaseCommunicator = ListAdminDatabaseCommunicatorImpl();


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater?.inflate(R.layout.list_list_fragment_layout, container, false)!!;
        initLayout(view);
        return view;
    }

    private fun initLayout(view:View){
        val addButton : FloatingActionButton = view.findViewById(R.id.list_add_button);
        val addLayout : View = view.findViewById(R.id.add_list_layout);
        this.animator  =  AddButtonAnimator(this.context, addLayout, addButton);

        //new list button to unhide the add layout
        addButton.setOnClickListener(View.OnClickListener {
            animator.animateLayout();
        });

        //add button to create a new list
        view.findViewById<View>(R.id.list_add_button).setOnClickListener(View.OnClickListener {
            val shopList = getListFromForm(view);
            this.listList.add(shopList);
            LogUtils.d(shopList.toString());
            //writing shopList to the cloud
            writeShopList(shopList);

            //adapting the layout to the change
            this.listAdapter.notifyDataSetChanged();
            this.animator.animateLayout();
        });
    }

    override fun onStart() {
        super.onStart();

        //creating the adapter and fetching the data
        putDummyDataOnIt();

        recyclerView = view!!.findViewById(R.id.lists_list)
        this.listAdapter = ListsAdapter(this.context,this.listList);
        recyclerView.setLayoutManager(GridLayoutManager(this.context,2,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(listAdapter);


    }

    private fun getListFromForm(view : View) : ShopList{
        val name = view.findViewById<EditText>(R.id.new_list_name).text.toString();
        val private = view.findViewById<CheckBox>(R.id.new_list_private).isChecked;
        val group = ""+view.findViewById<Spinner>(R.id.new_list_group_spinner).selectedItemPosition;

        return ShopList(name = name, groupId = group, personal = private, items = ArrayList(), updatingDate = Date(), createUserId = AuthenticationUtils.getAuthenticatedUser()?.uid);
    }

    private fun writeShopList(shopList : ShopList){
        listDatabaseCommunicator.create(shopList);
    }

    private fun loadLists(){
        //listDatabaseCommunicator.
    }

    private fun putDummyDataOnIt() {
        listList.add(ShopList("test", "Dummy 1", "GRUPO", false, "user", Date(), ArrayList()))
        listList.add(ShopList("test2","Dummy 2", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test3","Dummy 3", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test4","Dummy 4", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test5","Dummy 5", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test6","Dummy 6", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test7","Dummy 7", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test8","Dummy 8", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test9","Dummy 9", "GRUPO", false, "user",Date(), ArrayList()))
        listList.add(ShopList("test10","Dummy 10", "GRUPO", false, "user",Date(), ArrayList()))
    }

    companion object {
        fun getInstance(): ListsFragment = ListsFragment();
    }

}
