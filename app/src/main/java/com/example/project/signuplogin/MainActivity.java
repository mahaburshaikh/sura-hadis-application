package com.example.project.signuplogin;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.label;

public class MainActivity extends AppCompatActivity{
    private Button btnLogout;
    int hr;
    int min;
    String label;
    private DBHandler DBHandler;
    Button b,b2,b1,b3,b4;

    public static final int LOGGEDIN = 1;
    public static final int NOTLOGGEDIN = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button2);
        b1=(Button)findViewById(R.id.button1);
        b3=(Button)findViewById(R.id.button4);
        b4=(Button)findViewById(R.id.button5);

        DBHandler = new DBHandler(this);
        btnLogout=(Button)findViewById(R.id.btnLogout);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,countActivity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SuraActivity.class);
                startActivity(intent);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,HadisActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CompasActivity.class);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, label);
                i.putExtra(AlarmClock.EXTRA_HOUR, hr);
                i.putExtra(AlarmClock.EXTRA_MINUTES, min);
                i.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                startActivity(i);
            }
        });

       btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DBHandler.updateSession(NOTLOGGEDIN);
               Toast.makeText(getApplicationContext(), "Successfully signed out", Toast.LENGTH_SHORT).show();
               finish();
           }
       });



    }
}
