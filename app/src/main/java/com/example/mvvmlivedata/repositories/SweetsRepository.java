package com.example.mvvmlivedata.repositories;

import com.example.mvvmlivedata.R;
import com.example.mvvmlivedata.datamodels.Sweets;

import java.util.ArrayList;

public class SweetsRepository {

    public static ArrayList<Sweets> getMyObjects() {

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
