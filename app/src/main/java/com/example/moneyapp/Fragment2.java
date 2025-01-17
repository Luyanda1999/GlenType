package com.example.moneyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment implements View.OnClickListener {
    EditText Amount;
    EditText Percent;
    TextView Results;
    TextView Results2;
    Button button, addingDB;
    DBOpenHelper MyDB;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment2_layout,container,false);

        initView();

        return view;
    }

    private void initView(){
        Amount= view.findViewById(R.id.Amount);
        Percent= view.findViewById(R.id.Percent);
        Results=view.findViewById(R.id.Results);
        Results2= view.findViewById(R.id.Results2);
        button= view.findViewById(R.id.button);
        addingDB= view.findViewById(R.id.AddingDB);
        button.setOnClickListener(this);

        addingDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(),Deposit_Activity.class);
                startActivity(intent);
            }
        });

        MyDB= new DBOpenHelper(view.getContext());
    }

    @Override
    public void onClick(View v) {


        double x= Double.parseDouble(Amount.getText().toString());
        double y= Double.parseDouble(Percent.getText().toString());
        if(y<=50) {
            double p = y / 100;

            double YAmount = x * p;
            double tot = x - YAmount;
            Results.setText(String.valueOf(YAmount));
            Results2.setText(String.valueOf(tot));
        }
        else {
            Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
        }
        String amount=Amount.getText().toString();
        String percent=Percent.getText().toString();
        String result=Results.getText().toString();
        String result2=Results2.getText().toString();
        boolean AddNum = MyDB.AddNum(amount, percent,result, result2);
        if (AddNum){
            Toast.makeText(getContext(), "Okay", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(), "not Okay", Toast.LENGTH_SHORT).show();
        }

    }
}

