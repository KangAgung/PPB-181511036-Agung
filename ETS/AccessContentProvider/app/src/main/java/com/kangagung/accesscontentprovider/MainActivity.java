package com.kangagung.accesscontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor c;

        CursorLoader cursorLoader = new CursorLoader(
                this,
                Uri.parse("content://com.example.android.contentprovidersample.provider/cheeses"),
                new String[] {"_id","name"},
                null,
                null,
                null
        );

        c = cursorLoader.loadInBackground();

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(list.getContext()));
        Adapter adapter = new Adapter();
        adapter.setCheeses(c);
        list.setAdapter(adapter);
    }

}
