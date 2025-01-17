package com.example.moneyapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    ArrayList id, amount/*, percent, result, result2*/;
    CustomAdapter(Context context,
                  ArrayList id,
                  ArrayList amount//,
                  //ArrayList percent,
                  //ArrayList result,
                  /*ArrayList result2*/){
        this.context=context;
        this.id= id;
        this.amount=amount;
        //this.percent=percent;
        //this.result=result;
        //this.result2=result2;
    }


    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View verse = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(verse);
    }

    @Override
    public void onBindViewHolder( CustomAdapter.MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf( id.get(position)));
        holder.amount.setText(String.valueOf((amount.get(position))));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, amount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id_text);
            amount=itemView.findViewById(R.id.amount_view);
        }
    }
}
