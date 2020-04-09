package com.example.aplikasiuntukuts;

import android.app.Application;
import android.database.Cursor;

import com.example.aplikasiuntukuts.data.Cheese;
import com.example.aplikasiuntukuts.data.CheeseDao;
import com.example.aplikasiuntukuts.data.SampleDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CheeseRepository {
    private LiveData<List<Cheese>> mAllCheese;

    public CheeseRepository(Application application) {
        SampleDatabase db = SampleDatabase.getInstance(application);
        CheeseDao mCheeseDao = db.cheese();
        mAllCheese = mCheeseDao.selectAllCheese();
    }

    public LiveData<List<Cheese>> getCheese() {
        return mAllCheese;
    }

}
