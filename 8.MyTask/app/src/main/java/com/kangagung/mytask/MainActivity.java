package com.kangagung.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    int request_code =1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Task> myDataset;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        myDataset = getAllTaskFromDB();

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }

    public void onClick(View view) {
        Intent i = new Intent("com.kangagung.mytask.AddTaskActivity");
        startActivityForResult(i,request_code);
    }

    public ArrayList<Task> getAllTaskFromDB() {
        ArrayList<Task> task = new ArrayList<>();
        DBAdapter db = new DBAdapter(this);

        // get all contact
        db.open();
        c = db.getAllTask();
        if (c.moveToFirst())
        {
            do {
                String nama = c.getString(1);
                task.add(new Task(nama));
            } while (c.moveToNext());
        }
        db.close();

        return task;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                Task newTask = (Task) i.getSerializableExtra("task");
                myDataset.add(newTask);
                DBAdapter db = new DBAdapter(this);
                db.open();
                long id = db.insertTask(newTask.getName());
                db.close();
            }
        }
    }
}
