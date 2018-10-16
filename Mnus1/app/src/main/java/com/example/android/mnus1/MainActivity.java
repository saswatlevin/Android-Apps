package com.example.android.mnus1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,0,0,"New");
        menu.add(0,0,1,"Open");
        menu.add(0,2,2,"Save");
        return true;
    }

}
