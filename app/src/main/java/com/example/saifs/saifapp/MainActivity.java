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
    EditText editText,editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editText = (EditText)findViewById(R.id.name);
        editText1=(EditText)findViewById(R.id.namegf);
    }

    public void printName(View v) {
        String name = editText.getText().toString();
        /*Toast toast=Toast.makeText(this,"Hello"+name,Toast.LENGTH_SHORT);
        toast.show();*/
        String namegf = editText1.getText().toString();
        if (name.isEmpty()|| name.startsWith(" ")) {
            Toast toast = Toast.makeText(this, "Enter Your Name without starting space", Toast.LENGTH_SHORT);
            toast.show();
        } else if (namegf.isEmpty()|| namegf.startsWith(" ")) {
            Toast toast1=Toast.makeText(this, "Enter Your Partner Name without starting space", Toast.LENGTH_SHORT);
            toast1.show();
        } else {
            Intent intent = new Intent(this, Second.class);
            intent.putExtra("name", name);
            intent.putExtra("namegf", namegf);
            startActivity(intent);

        }
    }
}
