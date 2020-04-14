package com.kangagung.mytask.data;

import java.io.Serializable;
import java.sql.Timestamp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task implements Serializable, Comparable<Task> {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name = "startDate")
    private String startDate;

    @ColumnInfo(name = "endDate")
    private String endDate;

    @ColumnInfo(name = "checked")
    private boolean isChecked;

    public Task(int id, String name, String startDate, String endDate, boolean isChecked){
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isChecked = isChecked;
    }

    public Task(int id, String name, Timestamp startDate, Timestamp endDate, boolean isChecked){
        this(id, name, startDate.toString(), endDate.toString(), isChecked);
    }

    public Task(String name,Timestamp startDate, Timestamp endDate, boolean isChecked){
        this(0,name,startDate,endDate,isChecked);
    }

    public Task(String name, Timestamp startDate, Timestamp endDate){
        this(name,startDate,endDate,false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked){
        this.isChecked = checked;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public Timestamp getStartDateTimestamp() {
        return Timestamp.valueOf(startDate);
    }

    public Timestamp getEndDateTimestamp() {
        return Timestamp.valueOf(endDate);
    }

    public Task getTask(){
        return this;
    }

    @Override
    public int compareTo(Task task) {
        return endDate.compareTo(task.endDate);
    }
}
