package com.example.saifs.saifapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editText = (EditText)findViewById(R.id.name);


    }

    public void printName(View v)
    {
        Intent intent = new Intent(this,Second.class);
        startActivity(intent);
    }
}
