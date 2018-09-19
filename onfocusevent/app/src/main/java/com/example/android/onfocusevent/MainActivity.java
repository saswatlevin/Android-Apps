package com.example.android.onfocusevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUn,etPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUn=(EditText)findViewById(R.id.etUn);
        etUn.setOnFocusChangeListener(this);
        etPw=(EditText)findViewById(R.id.etPw);
        etPw.setOnFocusChangeListener(this);
    }
    public void OnFocusChange(View v, boolean hasFocus){
     if(!hasFocus)
     {
         return;
     }
    if (v==etUn)
        Toast.makeText(this,"Please Enter Username",Toast.LENGTH_LONG).show();
   else if(v==etPw)
       Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
    }
}
