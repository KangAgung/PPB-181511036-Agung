package com.kangagung.inputNama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare Variables
    EditText TextNama;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextNama = (EditText) findViewById(R.id.TxtName);
        Hasil = (TextView) findViewById(R.id.label_Name);
    }

    public void tampilNama(View v) {
        Hasil.setText("Nama Anda: "+TextNama.getText());
    }


}
