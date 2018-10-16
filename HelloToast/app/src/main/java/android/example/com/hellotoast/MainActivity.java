package android.example.com.hellotoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.app.Activity;
import android.widget.Toast;
import android.content.Context;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag = "Activity_lc";
    private int mCount=0;
    private TextView mShowCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag,"Activity created");
        mShowCount= (TextView) findViewById(R.id.show_count);


    }


    public void countUp(View view){

        mCount ++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void showToast(View view) {

        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context, R.string.toast_message, Toast.LENGTH_LONG);
        toast.show();
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

