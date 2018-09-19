package com.example.android.testcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

private int vcount=0;
public void onStart(){
  super.onStart();
  vcount++;
  Log.i("Count",vcount+"");
 }

}
