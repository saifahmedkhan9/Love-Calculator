package com.example.saifs.saifapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;
import java.lang.String;

import java.util.Calendar;


public class Second extends ActionBarActivity {

    int i=0,chek_for_luv=0,count=0,k=0;
    int arr[]=new int[100],chek_for_secondname=0,num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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

    public void get(View view)
    {

        Bundle bundle = getIntent().getExtras();
        String name= bundle.getString("name");
        char[] name1=name.toCharArray();
        String namegf =bundle.getString("namegf");
        char[] namegf1=namegf.toCharArray();
        Calendar calendar=Calendar.getInstance();
        int y=calendar.get(Calendar.YEAR);//Fetching Current Year
        DatePicker datePicker=(DatePicker)findViewById(R.id.datepicker);
        int yy=datePicker.getYear();//Fetching the year given by user
        /*Toast toast=Toast.makeText(this,"Hello "+yy,Toast.LENGTH_SHORT);
        toast.show();*/
        int add_to_percentage=y-yy;
        if(add_to_percentage<0)
        {
            Toast toast=Toast.makeText(this,"Your Starting Relationship date is wrong",Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {

            k=0;
            for(i=0;i<name.length();i++)
            {
                count=1;
                if(name1[i]=='L' ||name1[i]=='O'||name1[i]=='V'||name1[i]=='E'||name1[i]=='l'||name1[i]=='o'||name1[i]=='v'||name1[i]=='e')
                {
                    count++;
                    chek_for_luv++;
                }
                for(int j=0;j<namegf.length();j++)
                {
                    if(name1[i]==namegf1[j])
                    {
                        count++;
                        chek_for_secondname++;
                    }
                }
                arr[k]=count;
                k++;
            }
            if(name.length()<namegf.length())
            {
                int len=namegf.length()-chek_for_secondname;
                if(len>0) {
                    for (i = 0; i < len; i++) {
                        arr[k++] = 1;
                    }
                }
            }
            if(chek_for_luv<4)
            {
                int len1=4-chek_for_luv;
                for(i=0;i<len1;i++)
                    arr[k++]=1;
            }
            k--;
            int u=k,flag=0;
            count=0;
            while(u>1) {

                for (i = 0; i <(u / 2) + 1; i++) {
                    if(i<k-i)
                    {

                        arr[i] = arr[i] + arr[k - i];
                    }

                }

                if(k%2==0)
                    k=k/2;
                else
                {
                    if(k==3)
                        k=2;
                    else
                        k=(k+1)/2-1;
                }

                if(k==1 || u==1)
                    break;
                if(u%2==0 && u!=1)
                {
                    u=u/2;
                }
                else
                {

                    u=(u+1)/2;
                }


            }

        }
        arr[1]=arr[1]+add_to_percentage;
        if(arr[0]>9)
        {
            arr[0]=9;
        }
        if(arr[1]>9)
        {
            arr[1]=9;
        }
        num=arr[0]*10+arr[1];
        String num1=String.valueOf(num);
        Intent intent = new Intent(this, ThirdPage.class);
        intent.putExtra("name",name);
        intent.putExtra("namegf",namegf);
        intent.putExtra("num",num1);
        startActivity(intent);
//        Toast toast1=Toast.makeText(this,"LOVE B/W "+name+" and "+namegf+" is "+num+" %",Toast.LENGTH_SHORT);
//        toast1.show();

    }
}
