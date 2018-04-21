package com.example.luckynuget.deskripsi_wisata;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

public class deskripsi_wisata extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    Toolbar toolbar;
    ImageButton buttonNature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deskripsi_wisata);

        viewPager = findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

            }
        };


