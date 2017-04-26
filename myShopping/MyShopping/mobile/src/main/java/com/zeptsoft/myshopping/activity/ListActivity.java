package com.zeptsoft.myshopping.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.core.activity.SingleFragmentActivity;
import com.zeptsoft.myshopping.core.fragments.ItemListFragment;


public class ListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragmentInstance() {
        return ItemListFragment.getInstance("por aqui o id");
    }
}