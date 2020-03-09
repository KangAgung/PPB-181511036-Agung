package com.kangagung.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAdapter db = new DBAdapter(this);

        //delete all contacts
        db.open();
        db.deleteAllContacts();
        db.close();

        //---add a contact---
        db.open();
        long id = db.insertContact("Jennifer Ann", "jenniferann@jfdimarzio.com");
        id = db.insertContact("Oscar Diggs", "oscar@oscardiggs.com");
        id = db.insertContact("Agung Tri","agung@email.com");
        db.close();

        // get all contact
        db.open();
        c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();

        // get a contact
        db.open();
        c = db.getContact(3);
        if (c.moveToFirst()){
            DisplayContact(c);
        } else {
            Toast.makeText(this,"No contact found", Toast.LENGTH_LONG).show();
        }
        db.close();

        // update contact
        db.open();
        if (db.updateContact(1,"Oscar Diggs","oscar@oscardinggs.com")){
            Toast.makeText(this,"Update Successful.",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Update failed",Toast.LENGTH_LONG).show();
        }
        db.close();

        // get all contact
        db.open();
        c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();

        //delete a contact
        db.open();
        if(db.deleteContact(1)){
            Toast.makeText(this,"Delete Successful",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Delete failed",Toast.LENGTH_LONG).show();
        }
        db.close();

        // get all contact
        db.open();
        c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }

    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
        "Name: " + c.getString(1) + "\n" +
        "Email:  " + c.getString(2),
            Toast.LENGTH_LONG).show();
    }
}
