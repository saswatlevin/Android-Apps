package android.example.com.myevent2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button b;
    private static long c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(this);
    }

    public void onClick(View view) {
        Toast t = Toast.makeText(this, ""+c, Toast.LENGTH_LONG);
        t.show();
    }


}
