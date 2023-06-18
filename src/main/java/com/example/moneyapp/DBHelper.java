package com.example.moneyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;


    public DBHelper(Context context) {
        super(context, "Login.DB", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table accounting(id INTEGER PRIMARY KEY AUTOINCREMENT, amount TEXT, percentage TEXT, result TEXT, result2 TEXT)");


    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int ii) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL(" DROP TABLE IF EXISTS accounting");
        onCreate(MyDB);


    }

    public boolean insertData(String username, String password)
    {
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("UserName", username);
        contentValues.put("password", password);
        long results= MyDB.insert("users", null, contentValues);

        if(results==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
        //Next TABLE

    }

    public boolean checkusername(String username){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username=? and password=?", new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*public boolean AddNum(String amount, String percent, String results, String results2){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("AMOUNT", amount);
        contentValues.put("PERCENTAGE", percent);
        contentValues.put("RESULTS", results);
        contentValues.put("RESULTS2", results2);
        long test =MyDB.insert("accounting",null,contentValues);
        if (test==-1){

            return false;
        }
        else{

            return true;
        }

    }*/
    public boolean AddIT(String amount, String percent, String result, String result2){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("AMOUNT", amount);
        contentValues.put("PERCENTAGE", percent);
        contentValues.put("RESULTS", result);
        contentValues.put("RESULTS2", result2);
        long results =MyDB.insert("accounting",null,contentValues);
        if (results==-1){

            return false;
        }
        else{

            return true;
        }

    }

}
