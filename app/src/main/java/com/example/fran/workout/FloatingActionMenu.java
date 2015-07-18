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
    private Animation secondary_fab_animation;
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

    public void SetOnclickListener(View.OnClickListener L){
        main_fab.setOnClickListener(L);
        for(int i=0; i<secondary_fab_num; i++)
            secondary_fab[i].setOnClickListener(L);
    }

    private void AnimateMenu(Context c){
        // FAB button its not clicked -> Floating menu must open.
        if(!fab_clicked) {
            // Load appropriate animations.
            main_fab_animation = AnimationUtils.loadAnimation(c, R.anim.fab_anim);
            secondary_fab_animation = AnimationUtils.loadAnimation(c, R.anim.small_fab_anim);

            // Start the appropriate animations over appropriate elements.
            main_fab.startAnimation(main_fab_animation);

            for(int i=0; i<secondary_fab_num; i++){
                secondary_fab[i].setVisibility(View.VISIBLE);
                secondary_fab[i].setEnabled(true);
                secondary_fab[i].startAnimation(secondary_fab_animation);
            }
            //secondary_fab[0].setVisibility(View.VISIBLE);
            //secondary_fab[0].startAnimation(secondary_fab_animation);
        }
        // FAB button its clicked -> Floating menu must close.
        else{
            // Load appropriate animations.
            main_fab_animation = AnimationUtils.loadAnimation(c, R.anim.fab_anim_reverse);
            secondary_fab_animation = AnimationUtils.loadAnimation(c, R.anim.small_fab_anim_reverse);

            // Start the appropriate animations over appropriate elements.
            for(int i=0; i<secondary_fab_num; i++){
                secondary_fab[i].startAnimation(secondary_fab_animation);
                secondary_fab[i].setEnabled(false);
                secondary_fab[i].setVisibility(View.INVISIBLE);
            }
            //secondary_fab[0].startAnimation(secondary_fab_animation);
            //secondary_fab[0].setVisibility(View.INVISIBLE);
            main_fab.startAnimation(main_fab_animation);
        }

        // Chang Fab state.
        fab_clicked = !fab_clicked;
    }

    public void onClickFab(int id, Context c){
        switch (id){
            // Click on MAIN FAB.
            case 0:
                AnimateMenu(c);
                break;

            // Click on First SECONDARY FAB.
            case 1:

                break;
        }
    }
}
