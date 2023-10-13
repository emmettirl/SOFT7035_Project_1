package com.example.soft7035project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity_VehicleListing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_listing);

        FloatingActionButton fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(Activity_VehicleListing.this, Activity_Main.class);
                startActivity(intentBack);
            }
        });


        // set fragment based on user choice on landing page
        int selectedTab = getIntent().getIntExtra("selectedTab",0);
        Fragment fragment = Fragment_VehicleListing.newInstance(selectedTab);
        replaceFragment(fragment);

    }

    private void replaceFragment(Fragment fragment) {
        //method to replace the fragment on activity load or when new tab is selected

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentFrame, fragment);
        fragmentTransaction.commit();
    }

}