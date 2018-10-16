    package com.example.android.thread_app_with_handler;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

    public class MainActivity extends AppCompatActivity {

        Handler h=new Handler() {
           @Override
           public void handleMessage(Message m) {
               TextView t = (TextView) findViewById(R.id.tv);
               t.setText("ABC");

           }
       };
           protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_main);

           }


           public void onClick(View view) {
               synchronized (this) {
                   try {
                       wait(20 * 1000);

                   } catch (Exception e) {

                   }
               }
               h.sendEmptyMessage(0);
           }


           }
