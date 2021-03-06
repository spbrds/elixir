package com.zeptsoft.myshopping.core.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.activity.GroupListActivity;
import com.zeptsoft.myshopping.activity.LoginActivity;
import com.zeptsoft.myshopping.core.fragments.ItemListFragment;
import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.utils.ActivityUtils;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;

/**
 * Created by SSBook on 26/04/17.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity{

    protected abstract Fragment getFragmentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // subActionView = (LinearLayout)findViewById(R.id.sub_action_container);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting up fragment

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.main_fragment);

        if(fragment == null){
            fragment = getFragmentInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.main_fragment, fragment)
                    .commit();
        }


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
        }else if(id == R.id.action_manage_groups){
            ActivityUtils.changeActivity(this, GroupListActivity.class, false);
        }else if(id == R.id.action_logout){
            AuthenticationUtils.logout(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
