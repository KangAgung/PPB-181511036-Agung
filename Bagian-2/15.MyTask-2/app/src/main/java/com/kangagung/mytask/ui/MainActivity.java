package com.kangagung.mytask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kangagung.mytask.R;
import com.kangagung.mytask.TaskViewModel;
import com.kangagung.mytask.data.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int request_code =1;
    private RecyclerView recyclerView;
    private TaskAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TaskViewModel mTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new TaskAdapter(this);
        recyclerView.setAdapter(mAdapter);

        mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        mTaskViewModel.getAllTask().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                mAdapter.setTasks(tasks);
            }
        });

    }

    public void onClick(View view) {
        Intent i = new Intent("com.kangagung.mytask.ui.AddTaskActivity");
        startActivityForResult(i,request_code);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                Task newTask = (Task) i.getSerializableExtra("task");
                mTaskViewModel.insert(newTask);
            }
        }
    }
}
