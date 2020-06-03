package com.example.mvvmlivedata;

import android.app.Application;
import android.content.Context;

import com.example.mvvmlivedata.viewmodels.MainActivityViewModel;

public class App extends Application {

    public MainActivityViewModel getViewModel() {
        return new MainActivityViewModel();
    }

}
