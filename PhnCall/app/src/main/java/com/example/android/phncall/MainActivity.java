package com.example.android.phncall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etPhno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
    if(!TextUtils.isEmpty(etPhno.getText())){
        Intent in=new Intent(Intent.ACTION_DIAL);
        in.setData(Uri.parse("tel:"+etPhno.getText()));
        startActivity(in);
    }

    else{
        Toast.makeText(this,"PLease Enter PhNo",Toast.LENGTH_LONG).show();
    }
    }
}
