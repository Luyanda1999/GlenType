package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView AccAccount;
    RecyclerView RCView;
    Button add;
    MyDBHelper myDB;
    ArrayList<String>  amount/*, percent, result, result2*/;
    ArrayList<Integer> id;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AccAccount=(TextView) findViewById(R.id.button);
        RCView=(RecyclerView) findViewById(R.id.RCView);
        add=(Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,Deposit_Activity.class);
                startActivity(intent);
            }
        });
        myDB= new MyDBHelper(getApplicationContext());
        id=new ArrayList<>();
        amount=new ArrayList<>();
        //percent=new ArrayList<>();
        //result=new ArrayList<>();
        //result2=new ArrayList<>();

        customAdapter=new CustomAdapter(MainActivity2.this,id, amount/*,percent,result,result2*/);
        RCView.setAdapter(customAdapter);
        RCView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        display();
    }
    void display(){
        Cursor cursor =myDB.readData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getInt(0));
                amount.add(cursor.getString(1));
                //percent.add(cursor.getDouble(2));
                //result.add(cursor.getDouble(3));
                //result2.add(cursor.getDouble(4));
            }
        }
    }
}