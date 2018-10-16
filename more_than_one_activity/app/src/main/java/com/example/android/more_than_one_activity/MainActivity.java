package com.example.android.more_than_one_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button btnl,btnp;
    private EditText etu,etp;
    private TextView tvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etu = (EditText) findViewById(R.id.etUn);
        EditText etp = (EditText) findViewById(R.id.etPw);
        Button btnl = (Button) findViewById(R.id.btnLogin);
        Button btnp = (Button) findViewById(R.id.btnPw);

    }

    public void onClick(View view) {
        if (view == btnl) {
            String un, pw;
            un = etu.getText().toString();
            pw = etp.getText().toString();
            switch(un){
                case "cat":
                    if(pw.equals("tiger")){
                        Intent in=new Intent(this,SecondActivity.class);
                        startActivity(in);
                    }

                        else if(!pw.equals("tiger")){
                        tvMsg.setText("Invalid username or password");
                        }
                        break;
                        default:tvMsg.setText("Invalid username or password");
                        break;
                        }
            }

        }

    }
