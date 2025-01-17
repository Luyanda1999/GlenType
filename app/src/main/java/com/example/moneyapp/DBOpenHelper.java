package com.example.moneyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    private Context context;
    public DBOpenHelper(Context context) {
        super(context, "MeTry.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table accountable(id INTEGER PRIMARY KEY AUTOINCREMENT, amount TEXT, percentage TEXT, result TEXT, result2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int a, int ab) {
        MyDB.execSQL("DROP TABLE IF EXISTS accountable");

    }
    public boolean AddNum(String amount, String percent, String result, String result2){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("AMOUNT", amount);
        contentValues.put("PERCENTAGE", percent);
        contentValues.put("RESULT", result);
        contentValues.put("RESULT2", result2);
        long test =MyDB.insert("accountable",null,contentValues);
        if (test==-1){
            return false;
        }
        else{
            return true;
        }

    }
   public Cursor getViewing(){
        SQLiteDatabase DB= this.getReadableDatabase();
        Cursor cursor=DB.rawQuery(" select * from accountable;",null);
        //Log.d(TAG, "getTotal: "+cursor.getCount());
        return cursor;
    }
    public String getSum(){
        SQLiteDatabase DB=this.getReadableDatabase();
        String sAmount;
        Cursor cursor=DB.rawQuery(" select count(result2) from accountable;",null);
        if(cursor.moveToFirst()){
            sAmount= String.valueOf(cursor.getDouble(4));
        }
        else{
            sAmount="0";
        }
        return sAmount;
    }

}
