package com.example.mvvmlivedata.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvvmlivedata.App;
import com.example.mvvmlivedata.R;
import com.example.mvvmlivedata.adapters.RecyclerAdapter;
import com.example.mvvmlivedata.datamodels.Sweets;
import com.example.mvvmlivedata.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.mvvmlivedata.repositories.SweetsRepository.getList;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private ProgressBar mProgressBar;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private MainActivityViewModel mMainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Press add button!", Toast.LENGTH_SHORT).show();


        // Setting up the Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;

        fab = (FloatingActionButton) findViewById(R.id.fab);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mMainActivityViewModel = getViewModel();

        mMainActivityViewModel.init();
        recyclerAdapter = new RecyclerAdapter(this, mMainActivityViewModel.getSweets().getValue());
        initRecyclerView();


    }
    @Override
    protected void onResume() {
        super.onResume();

        bind();
    }

    private void bind(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMainActivityViewModel.addNewValue(getRandomElement());
            }
        });

        mMainActivityViewModel.getSweets().observe(this, new Observer<List<Sweets>>() {
            @Override
            public void onChanged(@Nullable List<Sweets> sweets) {
                recyclerAdapter.notifyDataSetChanged();

            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    if(recyclerView.getChildAt(0)==null) {
                        mMainActivityViewModel.addNewValue(getRandomElement());
                    }
                    recyclerView.smoothScrollToPosition(mMainActivityViewModel.getSweets().getValue().size()-1);
                }
            }
        });




    }
    // Function select an element base on index
    // and return an element
    public Sweets getRandomElement() {
        Random rand = new Random();
        List<Sweets> list = getList();

        return  list.get(rand.nextInt(list.size()));
    }
    private void initRecyclerView(){

        // Setting up the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }
    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
    private MainActivityViewModel getViewModel() {
        return ((App) getApplication()).getViewModel();
    }
}
