package com.zeptsoft.myshopping.core.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.core.MyShoppingApplication;
import com.zeptsoft.myshopping.core.adapters.ItemListAdapter;
import com.zeptsoft.myshopping.core.adapters.SelectableItem;
import com.zeptsoft.myshopping.core.listmanager.IListManager;
import com.zeptsoft.myshopping.core.listmanager.ListManager;
import com.zeptsoft.myshopping.core.ui.AddButtonAnimator;
import com.zeptsoft.myshopping.datatypes.Item;
import com.zeptsoft.myshopping.notification.NotificationHelper;

/**
 * Created by SSBook on 10/04/17.
 */

public class ItemListFragment extends Fragment{

    private static final String LIST_ID_EXTRA_ID = "com.myshopping.list_id";
    private AddButtonAnimator addButtonAnimator;

    private LinearLayout addLayout;
    private ImageButton addButton;

    private RecyclerView itemRecyclerView;
    private ItemListAdapter adapter;
    private IListManager listManager;
    private Button addItemButton;
    private EditText itemNameEdit;
    private EditText itemCategoryEdit;
    private EditText itemObservationsEdit;
    private CheckBox itemUrgentCheck;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.list_fragment_layout, container,false);
        initLayout(fragmentView);

        return fragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        //initiating ListManager and list
        if(listManager == null) {
            listManager = new ListManager(this.getArguments().getString(LIST_ID_EXTRA_ID));
            adapter = new ItemListAdapter(this.getActivity(), listManager.getList());
            itemRecyclerView.setAdapter(adapter);
            itemRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //refreshing the adapter for when activity returns
        adapter.notifyDataSetChanged();

    }

    private void initLayout(View v){
        itemRecyclerView = (RecyclerView)v.findViewById(R.id.productList);
        addLayout = (LinearLayout) v.findViewById(R.id.add_layout);
        addButton = (ImageButton) v.findViewById(R.id.list_add);
        addButtonAnimator = new AddButtonAnimator(this.getContext(),addLayout, addButton);

        registerButtonsListener(v);
    }


    private void registerButtonsListener(View v){

        v.findViewById(R.id.list_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listManager.deleteSelectedItems();
                updateListView();
            }
        });

        v.findViewById(R.id.list_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listManager.checkSelectedItems();
                updateListView();
            }
        });

        //registering notificationButton
        v.findViewById(R.id.fabNot).setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notification Created", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //initiating navigation
                MyShoppingApplication app = (MyShoppingApplication)getActivity().getApplicationContext();
                app.getNavigator().startNavigation(listManager,"");

                //showing notification
                buildNotification();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonAnimator.animateLayout();

            }
        });

        addItemButton = (Button) v.findViewById(R.id.item_add_button);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToList();
            }
        });

    }


    private void addItemToList(){
        bindFormFields();

        Item item = new Item();
        item.setName(itemNameEdit.getText().toString());
        item.setCategory(itemCategoryEdit.getText().toString());
        item.setObservations(itemObservationsEdit.getText().toString());
        item.setUrgent(itemUrgentCheck.isChecked());

        listManager.addItem(item);
        updateListView();

        clearAddForm();
    }

    private void bindFormFields(){
        if(itemNameEdit == null){
            itemNameEdit = (EditText) getView().findViewById(R.id.new_item_name);
            itemCategoryEdit = (EditText) getView().findViewById(R.id.new_item_category);
            itemObservationsEdit = (EditText) getView().findViewById(R.id.new_item_observations);
            itemUrgentCheck = (CheckBox) getView().findViewById(R.id.new_item_urgent_check);
        }
    }

    private void clearAddForm(){
        itemNameEdit.setText(null);
        itemCategoryEdit.setText(null);
        itemObservationsEdit.setText(null);
        itemUrgentCheck.setChecked(false);

        addButtonAnimator.animateLayout();
    }

    private void updateListView(){
        //clearing selection
        this.clearSelection();
        adapter.notifyDataSetChanged();
    }

    private void clearSelection(){
        for(SelectableItem i : listManager.getList()){
            i.setSelected(false);
        }
    }

    public void buildNotification(){
        //mudar o builder e o Manager para statics numa classe
        //para poder fazer o update da notificação
        NotificationHelper.getInstance().buildNotification(this.getActivity());

    }


    public static ItemListFragment getInstance(String listId){
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putString(LIST_ID_EXTRA_ID,listId);

        fragment.setArguments(args);
        return fragment;
    }

}
