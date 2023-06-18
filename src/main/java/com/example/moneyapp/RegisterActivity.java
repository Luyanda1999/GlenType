package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, cpassword;
    Button regist;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText) findViewById(R.id.UserName1);
        password=(EditText) findViewById(R.id.Password1);
        cpassword=(EditText) findViewById(R.id.CPassword);
        regist=(Button) findViewById(R.id.Regist);
        TextView bttn=findViewById(R.id.loginPage);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,Login.class));
            }
        });
        DB= new DBHelper(this);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass= password.getText().toString();
                String cpass= cpassword.getText().toString();

                if(user.equals("")||pass.equals("")||cpass.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"Field(s) is/are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(cpass)){
                        Boolean checkuser =DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"User already exists! Please go back and sign in",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Passwords not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}