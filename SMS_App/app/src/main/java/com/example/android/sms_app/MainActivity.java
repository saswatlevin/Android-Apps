package com.example.android.sms_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private int id;
    Button sendBtn;
    EditText txtPhoneNo;
    EditText txtMessage;
    String phoneno;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {
        phoneno = txtPhoneNo.getText().toString();
        message = txtMessage.getText().toString();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }

        }
    }


    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                Toast.makeText(getApplicationContext(), grantResults.length + "", Toast.LENGTH_SHORT).show();
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneno, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "SMS Not Sent", Toast.LENGTH_SHORT).show();
                    return;
                }
            }


        }
    }

    public void onClick(View v) {
        id = v.getId();
        switch (id) {

            case R.id.sendBtn:
                sendSMSMessage();

        }



        /*EditText et = (EditText) findViewById(R.id.txtPhoneNo);
        Intent in = new Intent(Intent.ACTION_SEND);
        in.setData(Uri.parse("tel:" + et.getText().toString()));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST);

        } else
            startActivity(in);*/
    }


}