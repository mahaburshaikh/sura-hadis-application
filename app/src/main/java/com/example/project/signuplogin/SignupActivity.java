package com.example.project.signuplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    private Button reg;
    private Button tvlogin;
    private EditText etEmail,etPass;
    private DBHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    db= new DBHandler(this);

         reg=(Button)findViewById(R.id.btnReg);
        tvlogin=(Button) findViewById(R.id.tvlogin);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);


        reg.setOnClickListener(this);
        tvlogin.setOnClickListener(this);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,WelcomeActivity.class);
                startActivity(intent);
            }
        });

    }




    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.tvlogin:
                break;
            default:
        }
    }


    private void  register(){
        String email=etEmail.getText().toString();
        String pass = etPass.getText().toString();
        if(email.isEmpty() && pass.isEmpty()){
           displayToast("Username/password field empty");
        }
        else{
            db.addUser(email,pass);
            displayToast("User Registered Successfully");
            finish();

        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();



    }

}
