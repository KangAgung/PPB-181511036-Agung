package com.example.aplikasiuntukuts.viewmodel;

import android.app.Application;

import com.example.aplikasiuntukuts.CheeseRepository;
import com.example.aplikasiuntukuts.data.Cheese;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CheeseViewModel extends AndroidViewModel {

    private final LiveData<List<Cheese>> mCheese;

    public CheeseViewModel(Application application) {
        super(application);
        CheeseRepository repository = new CheeseRepository(application);
        mCheese = repository.getCheese();
    }

    public LiveData<List<Cheese>> getAllCheese() { return mCheese; }
}
