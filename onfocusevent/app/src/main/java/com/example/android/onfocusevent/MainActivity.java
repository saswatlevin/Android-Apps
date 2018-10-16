package com.example.android.onfocusevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private final EditText etUn= (EditText)findViewById(R.id.Username);
    private final EditText etPw= (EditText)findViewById(R.id.Password);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUn.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus) {
                    Toast t=Toast.makeText(getApplicationContext(),"Enter Your Username",Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });

        etPw.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus) {
                    Toast t=Toast.makeText(getApplicationContext(),"Enter Your Password",Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });

    }


}

