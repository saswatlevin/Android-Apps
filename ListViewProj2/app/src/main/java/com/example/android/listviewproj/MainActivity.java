package com.example.android.listviewproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    ListView lv;
    ArrayAdapter<CharSequence> aa;
    ArrayList<CharSequence> al;
    CharSequence[] states = {"Karnataka", "Delhi", "Andhra Pradesh", "Meghalaya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        al=new ArrayList<CharSequence>();
        for(int i=0;i<states.length;++i)
            al.add(states[i]);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> av, View v,int pos,long d) {
      CharSequence current=(CharSequence)av.getItemAtPosition(pos);
      //Toast.makeText(this,pos+"",Toast.LENGTH_LONG).show();
      al.remove(current);//delete item at position pos
      aa.notifyDataSetChanged();//called each time change made to array
    }
}