package com.example.android.mnucontext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView ls1;
    String contacts[] = {"Ajay", "Sachin", "C", "D", "E"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls1 = (ListView) findViewById(R.id.ls1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        ls1.setAdapter(adapter);
        registerForContextMenu(ls1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, v.getId(), 0, "Call");//groupId itemId,title
        menu.add(0, v.getId(), 0, "SMS");
    }


    public boolean OnContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo ai = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getTitle() == "Call") {
            Toast.makeText(getApplicationContext(), "Calling code" + contacts[ai.position], Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "SMS") {
            Toast.makeText(getApplicationContext(), "Sending SMS code" + contacts[ai.position], Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
      return true;
    }
}