package com.example.android.phncllpermission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        EditText et = (EditText) findViewById(R.id.etTelNo);
        Intent in = new Intent(Intent.ACTION_CALL);
        in.setData(Uri.parse("tel:" + et.getText().toString()));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);

        } else
            startActivity(in);
    }


    public void onRequestPermissionResult(int rc, String[] perms, int[] grantr) {
        switch (rc) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE:
                if (grantr.length > 0 && grantr[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    EditText et = (EditText) findViewById(R.id.etTelNo);
                    i.setData(Uri.parse("tel:" + et.getText().toString()));
                    startActivity(i);
                }
        }
    }
}