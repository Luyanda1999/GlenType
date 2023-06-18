package com.example.moneyapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment1 extends Fragment {
    TextView AccountTot, dataview;
    double M;
    DBOpenHelper DB;
    View v;
    Button hide;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment1_layout,container,false);
        AccountTot= v.findViewById(R.id.AccountTot);
        dataview=v.findViewById(R.id.datatxt);
        hide=v.findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Hide_Activity.class);
                startActivity(intent);
            }
        });
        DB=new DBOpenHelper(v.getContext());
        Cursor cursor= DB.getViewing();
        StringBuilder SB= new StringBuilder();
        StringBuilder CB= new StringBuilder();

        while(cursor.moveToNext()){
            M+=cursor.getDouble(4);
            SB.append("Amount: R"+cursor.getDouble(4)+"\n");

        }
        CB.append("Balance \nR" +M);
        dataview.setText(SB);

        AccountTot.setText(CB);
        return v;
    }

}
