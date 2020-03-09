package com.kangagung.mytask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
    }

    public void onClick(View view) {
        Intent i = new Intent();

        EditText taskName = (EditText) findViewById(R.id.taskName);

        Task newTask = new Task(taskName.getText().toString());
        Bundle extras = new Bundle();
        extras.putSerializable("task",newTask);
        i.putExtras(extras);

        setResult(RESULT_OK, i);
        finish();

    }
}
