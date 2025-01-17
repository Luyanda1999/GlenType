package com.example.moneyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String TABLE_NAME="Accounted";
    private static final String COLUMN_ID="ID";
    private static final String AMOUNT="AmountTot";
    private static final String PERCENTAGE="Percentage";
    private static final String RESULT="Result";
    private static final String RESULT2="Result2";
    public MyDBHelper(@Nullable Context context) {
        super(context, "Money.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String query=
                " CREATE TABLE " +TABLE_NAME+ "("
                        + COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + AMOUNT + " DOUBLE, "
                        +PERCENTAGE+ " DOUBLE, "
                        +RESULT+ " DOUBLE, "
                        +RESULT2+ " DOUBLE );";
        MyDB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop table if exists Accounted");
        onCreate(MyDB);
    }
    void AddNum(Double AmountTot1, Double Percentage){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(AMOUNT, AmountTot1);
        cv.put(PERCENTAGE, Percentage);

        long result =MyDB.insert(TABLE_NAME,null,cv);
        if (result==-1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
        }

    }
    Cursor readData(){
        String query=" SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=null;
        if (MyDB !=null){
            MyDB.rawQuery(query,null);
        }
        return cursor;
    }
}
