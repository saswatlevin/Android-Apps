package com.example.saswat.mit_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
public class MainActivity extends AppCompatActivity {

    String tag="Activity_lc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag,"Activity created");
    }

protected void onStart() {

super.onStart();
Log.i(tag,"Activity Started");
}

protected void onPause(){

super.onPause();
Log.i(tag,"Activity Paused");
}

protected void onResume(){

super.onResume();
Log.i(tag,"Activity Resumed");
}

protected void onStop(){

super.onStop();
Log.i(tag,"Activity Stopped");
}

protected void onRestart(){

super.onRestart();
Log.i(tag,"Activity Restarted");
}


}
