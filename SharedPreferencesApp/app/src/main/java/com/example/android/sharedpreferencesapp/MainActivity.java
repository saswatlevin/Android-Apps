package com.example.android.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton btnYes,btnNo;
    EditText etInt,etFloat,etLong,etString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnYes=(RadioButton)findViewById(R.id.btnYes);
        btnNo=(RadioButton)findViewById(R.id.btnNo);
        etInt=(EditText)findViewById(R.id.etInt);
        etFloat=(EditText)findViewById(R.id.etFloat);
        etLong=(EditText)findViewById(R.id.etLong);
        etString=(EditText)findViewById(R.id.etString);
        loadSharedPrefs();
    }

    private void loadSharedPrefs() {
        SharedPreferences sp=getSharedPreferences("Settings", Context.MODE_PRIVATE);
        btnYes.setChecked(sp.getBoolean("boolean",true));
        btnNo.setChecked(!sp.getBoolean("boolean",true));
        etInt.setText(sp.getInt("int",0)+"");
        etFloat.setText(sp.getFloat("float",0)+"");
        etLong.setText(sp.getLong("long",0)+"");
        etString.setText(sp.getString("string",""));
    }

    private void saveSharedPrefs() {
        SharedPreferences sp=getSharedPreferences("Settings", Context.MODE_PRIVATE);
        //btnYes.setChecked(sp.getBoolean("boolean",true));
        //btnNo.setChecked(sp.getBoolean("boolean",true));
        SharedPreferences.Editor ed=sp.edit();
        ed.putBoolean("boolean",btnYes.isChecked());
        ed.putInt("int",Integer.parseInt(etInt.getText().toString()));
        ed.putFloat("float",Float.parseFloat(etFloat.getText().toString()));
        ed.putLong("long",Long.parseLong(etLong.getText().toString()));
        ed.putString("string",etString.getText().toString());
        ed.commit();
    }

    private void clearUI(){
        btnYes.setChecked(true);
        etInt.setText("");
        etFloat.setText("");
        etLong.setText("");
        etString.setText("");
    }
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btnSave:
                saveSharedPrefs();
                break;
            case R.id.btnClear:
                clearUI();
                break;
            case R.id.btnLoad:
                loadSharedPrefs();
                break;
        }
    }
}