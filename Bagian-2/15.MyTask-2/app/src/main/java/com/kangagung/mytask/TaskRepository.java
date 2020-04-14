package com.kangagung.mytask;

import android.app.Application;

import com.kangagung.mytask.data.Task;
import com.kangagung.mytask.data.TaskDB;
import com.kangagung.mytask.data.TaskDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TaskRepository {
    private LiveData<List<Task>> mAllTask;
    private TaskDao mTaskDao;

    public TaskRepository(Application application) {
        TaskDB db = TaskDB.getInstance(application);
        mTaskDao = db.taskDao();
        mAllTask = mTaskDao.getTasks();
    }

    LiveData<List<Task>> getTask() {
        return mAllTask;
    }

    void insert(final Task task){
        TaskDB.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskDao.insert(task);
            }
        });
    }

    void update(final Task task){
        TaskDB.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskDao.update(task);
            }
        });
    }

    void deleteAll(){
        TaskDB.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTaskDao.deleteAll();
            }
        });
    }

}
