package com.example.aplikasiuntukuts.viewmodel;

import android.app.Application;

import com.example.aplikasiuntukuts.CheeseRepository;
import com.example.aplikasiuntukuts.data.Cheese;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CheeseViewModel extends AndroidViewModel {

    private final LiveData<Cheese> mCheese;

    public CheeseViewModel(Application application) {
        super(application);
        CheeseRepository repository = new CheeseRepository(application);
        mCheese = (LiveData<Cheese>) repository.getCheese();
    }

    public LiveData<Cheese> getAllCheese() { return mCheese; }
}
