package com.example.moneyapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    DBOpenHelper DB;
    EditText out;
    Button change;
    TextView result3;
    View view1;
    double M,T;
    //double deduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view1=inflater.inflate(R.layout.fragment3_layout,container,false);
        out=view1.findViewById(R.id.Out);
        change=view1.findViewById(R.id.Withdraw);
        result3=view1.findViewById(R.id.Results3);
        DB= new DBOpenHelper(view1.getContext());
        Cursor cursor= DB.getViewing();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder TB= new StringBuilder();
                T=Double.parseDouble(out.getText().toString());
                while(cursor.moveToNext()) {
                    M += cursor.getDouble(4);
                    //deduct=M-T;
                }
                //T=Double.parseDouble(out.getText().toString());
                /*if(T>M){
                    deduct=M-T;

                }
                TB.append(deduct);
                result3.setText(TB);*/
                TB.append(M);
                result3.setText(TB);
            }
        });


        return view1;
    }
}
