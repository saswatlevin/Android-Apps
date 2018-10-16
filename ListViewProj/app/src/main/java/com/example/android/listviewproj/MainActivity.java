package com.example.android.listviewproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> aa=ArrayAdapter.createFromResource(this,R.array.states_array,R.layout.spinner_item);
        aa.setDropDownViewResource(R.layout.spinner_item);
        sp.setAdapter(aa);
    }

public void onCLick(View v)
{

}

}
