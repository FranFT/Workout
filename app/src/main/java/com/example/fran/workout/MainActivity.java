package com.example.fran.workout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    private FloatingActionMenu fam;
    private View.OnClickListener onClick_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar set up.
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle(R.string.toolbar_name);

        // Floating action menu set up.
        //// Creating Floating Action Menu.
        fam = new FloatingActionMenu(this);

        //// Assigning resource buttons.
        fam.main_fab = (FloatingActionButton) findViewById(R.id.fab_button);
        fam.secondary_fab[0] = (FloatingActionButton) findViewById(R.id.small_fab_button_1);

        //// Hiding Floating Action Menu.
        fam.Hide_fam();

        // Start up main floating button animation.
        fam.FAB_Start_Up_Animation();

        // Setting up Floating action menu onclick listener.
        onClick_fab = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fab_button:
                        fam.onClickFab(0, MainActivity.this);
                        break;
                    case R.id.small_fab_button_1:
                        fam.onClickFab(1, MainActivity.this);
                        break;

                    //
                    // Add other buttons.
                    //
                }
            }
        };

        fam.SetOnclickListener(onClick_fab);
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
}



/*public class MainActivity extends AppCompatActivity {


//Declaring needed variables.

    private static final String TAG = "MainActivity";

    // Activity's toolbar.
    private Toolbar toolbar;

    // Big FAB.
    private FloatingActionButton fab;
    // Small FAB
    private FloatingActionButton fab_create_folder;

    // FAB's animation object.
    private Animation fab_animation;
    private Animation small_fab_anim;
    private boolean fab_animation_state = true;

    // Current view.
    private View current_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    //Finding needed view elements.

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        fab = (FloatingActionButton) findViewById(R.id.fab_button);
        fab_create_folder = (FloatingActionButton) findViewById(R.id.fab_button_small_create_folder);
        current_view = findViewById(R.id.main_layout);


    //Setting up view elements.

        fab_create_folder.setVisibility(View.INVISIBLE);

        // Start Big FAB animation.
        fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_start_anim);
        fab.startAnimation(fab_animation);

        // Toolbar Setup.
        toolbar.setTitle("My Workouts");
        setSupportActionBar(toolbar);


        // Setting up FAB when clicked.
        View.OnClickListener onClick_fab = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(fab_animation_state) {
                    fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_anim);
                    small_fab_anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.small_fab_anim);

                    // Start animations.
                    fab.startAnimation(fab_animation);
                    fab_create_folder.setVisibility(View.VISIBLE);
                    fab_create_folder.startAnimation(small_fab_anim);
                }
                else {
                    fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_anim_reverse);
                    small_fab_anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.small_fab_anim_reverse);

                    fab_create_folder.startAnimation(small_fab_anim);
                    fab.startAnimation(fab_animation);
                }

                // Change animation state.
                fab_animation_state=!fab_animation_state;

                // Start animations.
                fab.startAnimation(fab_animation);

                fab_create_folder.setVisibility(View.VISIBLE);
                fab_create_folder.startAnimation(small_fab_anim);

            }
        };

        // Setting up reset animation when click the screen.
        View.OnClickListener reset_fab_animation = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!fab_animation_state) {
                    fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_anim_reverse);
                    fab.startAnimation(fab_animation);
                    fab_animation_state = !fab_animation_state;
                }
            }
        };



     //Assigning listeners.


        fab.setOnClickListener(onClick_fab);
        current_view.setOnClickListener(reset_fab_animation);
        toolbar.setOnClickListener(reset_fab_animation);

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
}*/
