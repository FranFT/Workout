package com.example.fran.workout;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Fran on 13/07/2015.
 */
public class FloatingActionMenu{
    /**
    * Class attributes.
    */
    private static final String TAG = "FloatingActionMenu";
    private int secondary_fab_num;
    private boolean fab_clicked;
    private Animation main_fab_animation;
    public FloatingActionButton main_fab;
    public FloatingActionButton[] secondary_fab;
    /**
     * Class constructor.
     * @param c Context needed for FloatingActionButton constructor.
     */
    public FloatingActionMenu(final Context c){
        // Set up main class attributes.
        secondary_fab_num = 3;
        fab_clicked = false;

        // Create main Floating Action Button.
        main_fab = new FloatingActionButton(c);

        // Create the 3 secondary Floating Action Buttons.
        secondary_fab = new FloatingActionButton[secondary_fab_num];
        for(int i=0; i<secondary_fab_num; i++)
            secondary_fab[i] = new FloatingActionButton(c);

        // Get the start animation.
        main_fab_animation = AnimationUtils.loadAnimation(c,R.anim.fab_start_anim);

    }

    /**
    *   Set Floating Action Menu buttons Invisible.
    */
    public void Hide_fam()
    {
        main_fab.setVisibility(View.INVISIBLE);
        for(int i=0; i<secondary_fab_num; i++)
            secondary_fab[i].setVisibility(View.INVISIBLE);
    }

    public void FAB_Start_Up_Animation(){
        main_fab.setVisibility(View.VISIBLE);
        main_fab.startAnimation(main_fab_animation);
    }

}
