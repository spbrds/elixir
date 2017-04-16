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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.zeptsoft.myshopping.datatypes.Item;
import com.zeptsoft.myshopping.notification.NotificationHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SSBook on 10/04/17.
 */

public class ItemListFragment extends Fragment{

    private static final String LIST_ID_EXTRA_ID = "com.myshopping.list_id";

    private Animation addRotation;
    private Animation addReset;

    private boolean addOpened = false;

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

        //updateListView();
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


        addButton = (ImageButton) v.findViewById(R.id.list_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateAddLayout();

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

        animateAddLayout();
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

    public void animateAddLayout(){
        initAnimations();

        if(addOpened){
            //subActionView.startAnimation(upAnimation);
            addButton.startAnimation(addReset);
            addLayout.setVisibility(View.GONE);
        }else{
            //subActionView.startAnimation(downAnimation);
            addButton.startAnimation(addRotation);
            addLayout.setVisibility(View.VISIBLE);
        }
        addOpened = !addOpened;

    }

    //initing animation and setting listeners
    public void initAnimations(){
        if(addRotation == null){
            addRotation = AnimationUtils.loadAnimation(this.getActivity(), R.anim.add_button_to_close);
        }

        if(addReset == null){
            addReset = AnimationUtils.loadAnimation(this.getActivity(), R.anim.add_button_reset);
        }

        /*if(upAnimation == null){
            upAnimation = AnimationUtils.loadAnimation(this, R.anim.list_sub_action_animator_up);
            upAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    subActionView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

        if(downAnimation == null){
            downAnimation = AnimationUtils.loadAnimation(this, R.anim.list_sub_action_animator_down);
            upAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    subActionView.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }*/
    }

    public static ItemListFragment getInstance(String listId){
        ItemListFragment fragment = new ItemListFragment();
        Bundle args = new Bundle();
        args.putString(LIST_ID_EXTRA_ID,listId);

        fragment.setArguments(args);
        return fragment;
    }

}
