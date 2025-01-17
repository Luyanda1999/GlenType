package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Deposit_Activity extends AppCompatActivity {
    EditText AccountTot1, Percentage;
    Button addition, Viewing;
    MyDBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        AccountTot1=(EditText) findViewById(R.id.AccountTot1);
        Percentage=(EditText) findViewById(R.id.Percentage);
        addition=(Button) findViewById(R.id.btn_Addition);
        Viewing=(Button) findViewById(R.id.Viewing);
        Viewing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Deposit_Activity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        addition.setOnClickListener(v -> {
            MyDB= new MyDBHelper(Deposit_Activity.this);
            MyDB.AddNum(Double.valueOf(AccountTot1.getText().toString().trim()),
                    Double.valueOf(Percentage.getText().toString().trim()));
        });
    }
}