package com.example.mvvmlivedata.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmlivedata.R;
import com.example.mvvmlivedata.adapters.RecyclerAdapter;
import com.example.mvvmlivedata.datamodels.Sweets;

import java.util.ArrayList;

import static com.example.mvvmlivedata.repositories.SweetsRepository.getMyObjects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Setting up the Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;

        // Setting up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Getting your ArrayList of objects
        final ArrayList<Sweets> sweets=getMyObjects();

        // RecyclerView with a click listener
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(sweets);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
