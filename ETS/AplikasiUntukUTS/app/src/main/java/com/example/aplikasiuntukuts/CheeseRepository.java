package com.example.aplikasiuntukuts;

import android.app.Application;
import android.database.Cursor;

import com.example.aplikasiuntukuts.data.CheeseDao;
import com.example.aplikasiuntukuts.data.SampleDatabase;

public class CheeseRepository {
    private CheeseDao mCheeseDao;
    private Cursor mAllCheese;

    public CheeseRepository(Application application) {
        SampleDatabase db = SampleDatabase.getInstance(application);
        mCheeseDao = db.cheese();
        mAllCheese = mCheeseDao.selectAll();
    }

    public Cursor getCheese() {
        return mAllCheese;
    }

}
