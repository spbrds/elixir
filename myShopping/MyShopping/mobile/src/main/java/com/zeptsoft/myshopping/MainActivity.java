package com.zeptsoft.myshopping;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.zeptsoft.myshopping.core.MyShoppingApplication;
import com.zeptsoft.myshopping.core.adapters.ItemListAdapter;
import com.zeptsoft.myshopping.core.listmanager.IListManager;
import com.zeptsoft.myshopping.core.listmanager.ListManager;
import com.zeptsoft.myshopping.core.listmanager.MockListManager;
import com.zeptsoft.myshopping.datatypes.Item;
import com.zeptsoft.myshopping.notification.NotificationHelper;




public class MainActivity extends AppCompatActivity {

    private Animation upAnimation;
    private Animation downAnimation;
    private Animation addRotation;
    private Animation addReset;

    private boolean addOpened = false;

    private LinearLayout subActionView;
    private RecyclerView itemRecyclerView;
    private ItemListAdapter adapter;
    private IListManager listManager;

    private LinearLayout addLayout;

    private ImageButton addButton;
    private Button addItemButton;

    private EditText itemNameEdit;
    private EditText itemCategoryEdit;
    private EditText itemObservationsEdit;
    private CheckBox itemUrgentCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       // subActionView = (LinearLayout)findViewById(R.id.sub_action_container);

        //initiating listManager
        listManager = new ListManager("por aqui id");

        itemRecyclerView = (RecyclerView)findViewById(R.id.productList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new ItemListAdapter(this, listManager.getList());
        itemRecyclerView.setAdapter(adapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        addLayout = (LinearLayout) findViewById(R.id.add_layout);

        //updateListView();
        registerButtonsListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registerButtonsListener(){
      /*  //registering reload button
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "List reseted", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });/
*/
         //registering notificationButton
        findViewById(R.id.fabNot).setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Notification Created", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //initiating navigation
                    MyShoppingApplication app = (MyShoppingApplication)getApplicationContext();
                    app.getNavigator().startNavigation(listManager,"");

                    //showing notification
                    buildNotification();
                }
            });


        addButton = (ImageButton) findViewById(R.id.list_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateAddLayout();

            }
        });

        addItemButton = (Button)findViewById(R.id.item_add_button);
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
            itemNameEdit = (EditText) findViewById(R.id.new_item_name);
            itemCategoryEdit = (EditText) findViewById(R.id.new_item_category);
            itemObservationsEdit = (EditText) findViewById(R.id.new_item_observations);
            itemUrgentCheck = (CheckBox) findViewById(R.id.new_item_urgent_check);
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
        adapter.notifyDataSetChanged();

    }

    public void buildNotification(){
        //mudar o builder e o Manager para statics numa classe
        //para poder fazer o update da notificação
        NotificationHelper.getInstance().buildNotification(this);

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
            addRotation = AnimationUtils.loadAnimation(this, R.anim.add_button_to_close);
        }

        if(addReset == null){
            addReset = AnimationUtils.loadAnimation(this, R.anim.add_button_reset);
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

}
