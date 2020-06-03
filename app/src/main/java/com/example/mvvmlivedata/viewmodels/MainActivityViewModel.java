package com.example.mvvmlivedata.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmlivedata.datamodels.Sweets;
import com.example.mvvmlivedata.repositories.SweetsRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {


    private MutableLiveData<List<Sweets>> mSweets;
    public LiveData<List<Sweets>> getSweets(){
        return mSweets;
    }
    private SweetsRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mSweets != null){
            return;
        }
        mRepo = SweetsRepository.getInstance();
        mSweets = mRepo.getSweets();
    }

    public void addNewValue(final Sweets sweet){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Sweets> currentSweets = mSweets.getValue();
                currentSweets.add(sweet);
                mSweets.postValue(currentSweets);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }




    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
