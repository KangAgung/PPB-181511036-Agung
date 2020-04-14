package com.kangagung.mytask;

import android.app.Application;

import com.kangagung.mytask.data.Task;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TaskViewModel extends AndroidViewModel {
    private final LiveData<List<Task>> mTask;
    private TaskRepository repository;

    public TaskViewModel(Application application) {
        super(application);
        repository = new TaskRepository(application);
        mTask = repository.getTask();
    }

    public LiveData<List<Task>> getAllTask() { return mTask; }

    public void insert(Task task){
        repository.insert(task);
    }

    public void update(Task task){
        repository.update(task);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
