package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText UserName;
    EditText Password;
    Button login;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserName=(EditText) findViewById(R.id.UserName);
        Password=(EditText) findViewById(R.id.Password);
        login=(Button) findViewById(R.id.login);

        DB= new DBHelper(this);

        TextView btn=findViewById(R.id.registration);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               String user= UserName.getText().toString();
               String pass= Password.getText().toString();

               if(user.equals("")||pass.equals(""))
               {
                   Toast.makeText(Login.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
               }
               else
               {
                   boolean checkuserpass = DB.checkusernamepassword(user, pass);
                   if(checkuserpass==true){
                       Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(intent);
                   }
                   else
                   {
                       Toast.makeText(Login.this,"Login Failed, Invalid Credentials",Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

    }
}