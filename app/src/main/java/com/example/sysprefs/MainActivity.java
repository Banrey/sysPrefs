package com.example.sysprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView ed1,ed2;
    Button b1,b2,b3;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(TextView) findViewById(R.id.editText);
        ed2=(TextView) findViewById(R.id.editText2);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)){
            ed1.setText(sharedpreferences.getString(Name,""));
        }
        if (sharedpreferences.contains(Email)){
            ed2.setText(sharedpreferences.getString(Email,""));
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String e  = ed2.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Email, e);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Save(View view){
        String n = ed1.getText().toString();
        String e = ed2.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }
    public void Clear(View view){
        ed1=(TextView) findViewById(R.id.editText);
        ed2=(TextView) findViewById(R.id.editText2);
        ed1.setText("");
        ed2.setText("");
    }
    public void Get(View view){
        ed1=(TextView) findViewById(R.id.editText);
        ed2=(TextView) findViewById(R.id.editText2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)){
            ed1.setText(sharedpreferences.getString(Name,""));
        }
        if (sharedpreferences.contains(Email)){
            ed2.setText(sharedpreferences.getString(Email,""));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }



}