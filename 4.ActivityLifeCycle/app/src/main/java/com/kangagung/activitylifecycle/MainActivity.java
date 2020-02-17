package com.kangagung.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate Invoked");
        Toast.makeText(this,"onCreated Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart Invoked");
        Toast.makeText(this,"onStart Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume Invoked");
        Toast.makeText(this,"onResume Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause Invoked");
        Toast.makeText(this,"onPause Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop Invoked");
        Toast.makeText(this,"onStop Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart Invoked");
        Toast.makeText(this,"onRestart Invoked",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy Invoked");
        Toast.makeText(this,"onDestroy Invoked",Toast.LENGTH_SHORT).show();
    }

}
