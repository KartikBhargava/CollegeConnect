package com.example.collegeconnect.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.collegeconnect.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpcomingEvents extends AppCompatActivity {
    private FloatingActionButton createEvent;
    Fragment upcomingevents = new EventsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_event);
        Toolbar toolbar = findViewById(R.id.toolbarcom);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        TextView tv = findViewById(R.id.tvtitle);
        tv.setText("Upcoming Events");
        createEvent = findViewById(R.id.createEvent);
        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(UpcomingEvents.this, CreateEvent.class));
            }
        });

        loadFragments(upcomingevents);
    }
    private boolean loadFragments(Fragment fragment)
    {
        if (fragment!=null)
        {
            Log.d("navigation", "loadFragments: Frag is loaded");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameupcomingevents,fragment)
                    .commit();

            return true;
        }
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                FragmentManager mgr = getSupportFragmentManager();
                if (mgr.getBackStackEntryCount() == 0) {
                    super.onBackPressed();
                    finish();
                }
                else
                    mgr.popBackStack();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}