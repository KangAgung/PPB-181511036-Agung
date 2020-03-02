package com.kangagung.mytask;

public class Task{
    private String name;
    private boolean isDone;

    public Task(String name){
        this.name = name;
        isDone = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone(){
        return isDone;
    }

}
