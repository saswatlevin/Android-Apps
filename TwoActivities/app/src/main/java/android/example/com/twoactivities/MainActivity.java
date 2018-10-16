package android.example.com.twoactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="android.example.com.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=(EditText)findViewById(R.id.editText_main);
    }

    public void launchSecondActivity(View view) {

        Log.d(LOG_TAG,"Button Clicked");
        Intent intent=new Intent(this,SecondActivity.class);
        String message=mMessageEditText.getText().toString();
        intent.putExtra(message,EXTRA_MESSAGE);
        startActivity(intent);

    }
}
