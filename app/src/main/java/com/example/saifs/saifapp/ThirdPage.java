package com.example.saifs.saifapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ThirdPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        String namegf=bundle.getString("namegf");
        String num=bundle.getString("num");
        TextView textView=(TextView)findViewById(R.id.textView3);
        textView.setText(name+"\n&");
        TextView textView1=(TextView)findViewById(R.id.textView5);
        textView1.setText(namegf);
        TextView textView2=(TextView)findViewById(R.id.textView4);
        textView2.setText(num+" %");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
    public void show()
    {

    }

}
