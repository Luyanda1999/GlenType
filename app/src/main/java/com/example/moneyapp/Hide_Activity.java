package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Hide_Activity extends AppCompatActivity {
    DBOpenHelper DB;
    TextView hiddenView,hiddenViewTot;
    double m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide);
        hiddenView=findViewById(R.id.hiddenView);
        hiddenViewTot=findViewById(R.id.hiddenViewTot);
        DB= new DBOpenHelper(getApplicationContext());

        Cursor cursor= DB.getViewing();
        StringBuilder SB= new StringBuilder();
        StringBuilder CB= new StringBuilder();
        while (cursor.moveToNext()){
            m+=cursor.getDouble(3);
            SB.append("Amount: R"+cursor.getDouble(3)+"\n");
        }
        CB.append("Balance \nR" +m);
        hiddenViewTot.setText(CB);
        hiddenView.setText(SB);
    }
}