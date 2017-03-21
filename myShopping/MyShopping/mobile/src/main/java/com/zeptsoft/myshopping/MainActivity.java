package com.zeptsoft.myshopping;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.zeptsoft.myshopping.notification.NotificationHelper;
import com.zeptsoft.myshopping.receivers.NotificationBroadcastReceiver;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String[] default_products = {"Leite","Queijo","Pão","Manteiga","Marmelada","Fiambre","Café"};
    private List<String> presentProducts;
    private ArrayAdapter<String> mAdapter;
    private ListViewCompat mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mListView = (ListViewCompat)findViewById(R.id.productList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resetProductList();
        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,presentProducts);
        mListView.setAdapter(mAdapter);

        updateListView();
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
                resetProductList();
                updateListView();
            }
        });

        //registering notificationButton
        findViewById(R.id.fabNot).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Notification Created", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        buildNotification();
                    }
                });
    }

    private void resetProductList(){
        presentProducts = Arrays.asList(default_products);
    }

    private void updateListView(){
        //using simple adapter for testing
        mAdapter.notifyDataSetInvalidated();
        mAdapter.notifyDataSetChanged();

    }

    public void buildNotification(){
        //mudar o builder e o Manager para statics numa classe
        //para poder fazer o update da notificação
        NotificationHelper.getInstance().buildNotification(this);

    }

}
