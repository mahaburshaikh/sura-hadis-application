package com.example.project.signuplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login,register;
    private EditText etEmail,etPass;

    private DBHandler db;

    public static final int LOGGEDIN = 1;
    public static final int NOTLOGGEDIN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        db= new DBHandler(this);
        login=(Button)findViewById(R.id.btnlogin);
        register=(Button)findViewById(R.id.btnReg);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(db.checkSession()){
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlogin:
                login  ();

                break;
            case R.id.btnReg:
                startActivity( new Intent(WelcomeActivity.this,SignupActivity.class));
                break;
            default:
        }
    }

    private  void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if (db.getUser(email,pass)){
            db.updateSession(LOGGEDIN);
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong email/password",Toast.LENGTH_LONG ).show();
        }
    }
}
