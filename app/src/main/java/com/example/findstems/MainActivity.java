package com.example.findstems;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.findstems.*;
import java.util.*;

public class MainActivity extends AppCompatActivity implements Tab1Fragment.Fragment1Listener {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private Tab1Fragment fragment1;
    private Tab2Fragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        //initialize each fragment and add it to PageAdapter
        fragment1 = new Tab1Fragment();
        fragment2 = new Tab2Fragment();

        adapter.addFragment(fragment1, "Enter Words");
        adapter.addFragment(fragment2, "See Stem History");
        viewPager.setAdapter(adapter);
    }

    //fragment communication
    @Override
    public void onInput1Sent(List<String> data) {
        //if fragment 1 sends over list of stems, call updateHistory in fragment 2
        fragment2.updateHistory(data);
    }

}