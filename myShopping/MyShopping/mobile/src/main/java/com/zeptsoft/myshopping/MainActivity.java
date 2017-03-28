package com.zeptsoft.myshopping;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zeptsoft.myshopping.core.MyShoppingApplication;
import com.zeptsoft.myshopping.core.listmanager.IListManager;
import com.zeptsoft.myshopping.core.listmanager.MockListManager;
import com.zeptsoft.myshopping.notification.NotificationHelper;

public class MainActivity extends AppCompatActivity {

    private Animation upAnimation;
    private Animation downAnimation;
    private boolean opened = false;

    LinearLayout subActionView;

    IListManager listManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        subActionView = (LinearLayout)findViewById(R.id.sub_action_container);

        //initiating listManager
        listManager = new MockListManager();

        //mListView = (ListViewCompat)findViewById(R.id.productList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,presentProducts);
       // mListView.setAdapter(mAdapter);

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
        //registering reload button
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "List reseted", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.list_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateLayout();
            }
        });

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
    }


    private void updateListView(){
        //using simple adapter for testing
       // mAdapter.notifyDataSetInvalidated();
        //mAdapter.notifyDataSetChanged();

    }

    public void buildNotification(){
        //mudar o builder e o Manager para statics numa classe
        //para poder fazer o update da notificação
        NotificationHelper.getInstance().buildNotification(this);

    }

    public void animateLayout(){
        initAnimations();

        if(opened){
            subActionView.startAnimation(upAnimation);
        }else{
           subActionView.startAnimation(downAnimation);
        }
        opened = !opened;

    }

    //initing animation and setting listeners
    public void initAnimations(){
        if(upAnimation == null){
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
        }
    }

}
