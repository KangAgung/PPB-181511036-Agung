package com.kangagung.mytask.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("DELETE FROM task")
    void deleteAll();

    @Query("SELECT * from task ORDER BY endDate ASC")
    LiveData<List<Task>> getTasks();

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Task task);

}
