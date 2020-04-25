package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int number,j,l[],oa,a1,n;
    EditText num;
    Button button;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name1 = "nameKey";
    public static final String Name2 = "nameKey2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=(EditText)findViewById(R.id.input);

        button =(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, second_screen.class);
                startActivity(intent);
                Log.d(TAG, "onClick: problem none");
                String temp=num.getText().toString();
                SharedPreferences shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString(Name1, temp);
                editor.commit();








            }

            });
        }
    }

