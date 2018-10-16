package com.example.android.mymnu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu_option,m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        switch(mi.getItemId()){
            case R.id.newm:
                Toast.makeText(getApplicationContext(),"New Menu", Toast.LENGTH_LONG).show();
                break;

            case R.id.open:
                Toast.makeText(getApplicationContext(),"Open Menu",Toast.LENGTH_LONG).show();
                break;
            case R.id.save:
                Toast.makeText(getApplicationContext(),"Save Menu",Toast.LENGTH_LONG).show();
                break;
            default:
                //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                return false;
        }
        return true;
    }
}
