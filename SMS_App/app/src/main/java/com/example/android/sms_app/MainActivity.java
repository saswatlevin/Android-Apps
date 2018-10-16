package com.example.android.sms_app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST=1;
    Button sendBtn;
    EditText txtPhoneNo;
    EditText txtMessage;
    String phoneno;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn=(Button)findViewById(R.id.sendBtn);
        txtPhoneNo=(EditText)findViewById(R.id.txtPhoneNo);
        txtMessage=(EditText)findViewById(R.id.txtMessage);
    }

  protected void sendSMSMessage() {
      phoneno = txtPhoneNo.getText().toString();
      message = txtMessage.getText().toString();
      if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

          if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

          } else {
              ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST);
          }

      }
  }




//@Override
public void onRequestPermissionResult(int requestCode,String permissions[],int [] grantResults){
    Toast.makeText(this,"After permission",Toast.LENGTH_SHORT).show();
    switch(requestCode){
        case MY_PERMISSIONS_REQUEST:{
            Toast.makeText(this,grantResults.length+"",Toast.LENGTH_SHORT).show();
            if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(phoneno,null,message,null,null);
                Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_SHORT).show();
            }

        else{
            Toast.makeText(getApplicationContext(),"SMS Not Sent",Toast.LENGTH_SHORT).show();
        }
}
    }
}
}