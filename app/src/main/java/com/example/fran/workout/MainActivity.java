package com.example.fran.workout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Activity's toolbar.
    private Toolbar toolbar;

    // FAB.
    private FloatingActionButton fab;

    // FAB's animation object.
    private Animation fab_animation;

    private boolean fab_animation_state = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding needed view elements.
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        fab = (FloatingActionButton) findViewById(R.id.fab_button);

        // Setting up Toolbar.
        toolbar.setTitle("My Workouts");
        setSupportActionBar(toolbar);

        // Setting up FAB when clicked.
        View.OnClickListener onClick_fab = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(fab_animation_state)
                    fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_anim);
                else
                    fab_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fab_anim_reverse);

                fab.startAnimation(fab_animation);
                fab_animation_state=!fab_animation_state;
            }
        };

        fab.setOnClickListener(onClick_fab);
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
