package com.example.project.signuplogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.os.Vibrator;

public class countActivity extends AppCompatActivity {

    TextView m1,total;
    Button mb,ref;
    int count=0;
    int countB=0;
    int sign=0;
    int subs=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        total=(TextView)findViewById(R.id.ttl);
        m1=(TextView)findViewById(R.id.cnt);

        mb=(Button)findViewById(R.id.clickme);
        ref=(Button)findViewById(R.id.fresh);

        m1.setText(""+count);
        total.setText(""+countB);

        mb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        count++;
        if(count>10){
            count = 0;
            countB++;
            total.setText(""+countB);
            Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);

        }
        m1.setText(""+count);


        }
});
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                countB = 0;

                m1.setText(""+count);
                total.setText(""+countB);
            }
        });


    }
}
