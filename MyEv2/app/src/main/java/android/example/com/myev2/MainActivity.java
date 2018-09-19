package android.example.com.myev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{
private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et1.addTextChangedListener(this);
        //et1.setOnKeyListener();//For hardware keys
    }
  /*public void onKey(View vi, int key, KeyEvent ke){
   Toast.makeText(this,key+" pressed", Toast.LENGTH_LONG).show();
  }*/
public void afterTextChanged(Editable s){
    Toast.makeText(this,"Text Changed :"+s.toString(),Toast.LENGTH_LONG).show();
}
public void beforeTextChanged(CharSequence s,int start,int count,int after){

    Toast.makeText(this,"Text Changed :"+s.toString(),Toast.LENGTH_LONG).show();
}
public void onTextChanged(CharSequence s,int start,int before,int count){

    Toast.makeText(this,"Text Changed :"+s.toString(),Toast.LENGTH_LONG).show();
}

}
