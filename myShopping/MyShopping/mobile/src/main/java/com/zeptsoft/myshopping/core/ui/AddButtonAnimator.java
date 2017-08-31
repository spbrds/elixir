package com.zeptsoft.myshopping.core.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.zeptsoft.myshopping.R;

/**
 * Created by SSBook on 17/05/17.
 */

public class AddButtonAnimator {

    private Context context;
    private Animation addButtonAnimation;
    private Animation resetAnimation;

    private boolean isAddLayoutOpened = false;

    private View addButton;
    private View addLayout;

    public AddButtonAnimator(@NonNull Context context, @NonNull View addLayout, @NonNull View addButton){
        this.context = context;
        this.addLayout = addLayout;
        this.addButton = addButton;
    }

    public void animateLayout(){
        initAnimations();

        if(isAddLayoutOpened){
            addButton.startAnimation(resetAnimation);
            addLayout.setVisibility(View.GONE);
        }else{
            addButton.startAnimation(addButtonAnimation);
            addLayout.setVisibility(View.VISIBLE);
        }
        isAddLayoutOpened = !isAddLayoutOpened;
    }

    //initing animation and setting listeners
    private void initAnimations(){
        if(addButtonAnimation == null){
            addButtonAnimation = AnimationUtils.loadAnimation(context, R.anim.add_button_to_close);
        }

        if(resetAnimation == null){
            resetAnimation = AnimationUtils.loadAnimation(context, R.anim.add_button_reset);
        }
    }

}
