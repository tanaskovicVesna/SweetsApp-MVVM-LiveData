package com.example.mvvmlivedata.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmlivedata.R;
import com.example.mvvmlivedata.datamodels.Sweets;

import java.util.ArrayList;
import java.util.List;

public class SweetsRepository {

    private static SweetsRepository instance;
    private ArrayList<Sweets> dataSet = new ArrayList<>();

    public static SweetsRepository getInstance(){
        if(instance == null){
            instance = new SweetsRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Sweets>> getSweets(){
        getList();
        MutableLiveData<List<Sweets>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    public static ArrayList<Sweets> getList() {

        final ArrayList<Sweets> sweets = new ArrayList<Sweets>();

        sweets.add(new Sweets("Applepie", R.drawable.applepie));
        sweets.add(new Sweets("Cheesecake", R.drawable.cheesecake));
        sweets.add(new Sweets("Coffeecookies", R.drawable.coffeecookies));
        sweets.add(new Sweets("Donuts", R.drawable.donuts));
        sweets.add(new Sweets("Fruitpie", R.drawable.fruitpie));
        sweets.add(new Sweets("Lemonpie", R.drawable.lemonpie));
        sweets.add(new Sweets("Macarons", R.drawable.macarons));
        sweets.add(new Sweets("Moonpie", R.drawable.moonpie));
        sweets.add(new Sweets("Muffins", R.drawable.muffins));
        sweets.add(new Sweets("Pancakes", R.drawable.pancakes));
        sweets.add(new Sweets("Pumpkinpie", R.drawable.pumpkinpie));

        return sweets;
    }
}
