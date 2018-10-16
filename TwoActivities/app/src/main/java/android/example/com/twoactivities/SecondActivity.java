package android.example.com.twoactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY="android.example.com.twoactivities.extra.REPLY";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        Intent replyIntent=new Intent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mReply=(EditText)findViewById(R.id.editText_second);
        String reply=mReply.getText().toString();
        replyIntent.putExtra(reply,EXTRA_REPLY);
        TextView textview=(TextView)findViewById(R.id.text_message);
        textview.setText(message);
    }

    public void returnReply(View view) {


    }
}
