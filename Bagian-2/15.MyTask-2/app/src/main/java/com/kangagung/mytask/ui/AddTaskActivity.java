package com.kangagung.mytask.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.kangagung.mytask.R;
import com.kangagung.mytask.data.Task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {
    DatePickerDialog datePicker;
    EditText endDate;
    EditText taskName;
    Button datePickerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        taskName = (EditText) findViewById(R.id.taskName);
        endDate = (EditText) findViewById(R.id.endDate);
        datePickerButton = (Button) findViewById(R.id.datePicker);

        endDate.setInputType(InputType.TYPE_NULL);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(AddTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        endDate.setText(year + "-"+ month + "-" + dayOfMonth);
                    }
                },year,month,day);
                datePicker.show();
            }
        });
    }

    public void onClick(View view) {
        String startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        String end = endDate.getText().toString()+' ' +"00:00:00";
        Intent i = new Intent();

        Task newTask = new Task(taskName.getText().toString(),
                Timestamp.valueOf(startDate),
                Timestamp.valueOf(end));

        Bundle extras = new Bundle();
        extras.putSerializable("task",newTask);
        i.putExtras(extras);

        setResult(RESULT_OK, i);
        finish();

    }
}
