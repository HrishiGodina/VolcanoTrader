package com.example.hrishi.volcanotrader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DBname = "VolcanoDB";
    private static final String Tname1 = "TradeTB1";
    private static final String Tname2 = "TradeTB2";
    private static final String Tname3 = "TradeTB3";
    private static final String Tname4 = "TradeTB4";
    private static final String price1 = "price1";
    private static final String price2 = "price2";
    private static final String price3 = "price3";
    private static final String price4 = "price4";
    private static final String capital1 = "capital1";
    private static final String capital2 = "capital2";
    private static final String capital3 = "capital3";
    private static final String capital4 = "capital4";
    private static final String Quantity1 = "quantity1";
    private static final String Quantity2 = "quantity2";
    private static final String Quantity3 = "quantity3";
    private static final String Quantity4 = "quantity4";
    private static final String stoploss1 = "stoploss1";
    private static final String stoploss2 = "stoploss2";
    private static final String stoploss3 = "stoploss3";
    private static final String stoploss4 = "stoploss4";
    private static final String target11 = "target11";
    private static final String target12 = "target12";
    private static final String target13 = "target13";
    private static final String target21 = "target21";
    private static final String target22 = "target22";
    private static final String target23 = "target23";
    private static final String target31 = "target31";
    private static final String target32 = "target32";
    private static final String target33 = "target33";
    private static final String target41 = "target41";
    private static final String target42 = "target42";
    private static final String target43 = "target43";


    public DataBaseHelper(Context context) {
        super(context, DBname, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + Tname1 + " (capital1 text default \"0\", price1 text default \"0\", Quantity1 text default \"0\", stoploss1 text default \"0\", target11 text default \"0\", target12 text default \"0\", target13 text default \"0\") ");
        db.execSQL(" create table " + Tname2 + " (capital2 text default \"0\", price2 text default \"0\", Quantity2 text default \"0\", stoploss2 text default \"0\", target21 text default \"0\", target22 text default \"0\", target23 text default \"0\") ");
        db.execSQL(" create table " + Tname3 + " (capital3 text default \"0\", price3 text default \"0\", Quantity3 text default \"0\", stoploss3 text default \"0\", target31 text default \"0\", target32 text default \"0\", target33 text default \"0\") ");
        db.execSQL(" create table " + Tname4 + " (capital4 text default \"0\", price4 text default \"0\", Quantity4 text default \"0\", stoploss4 text default \"0\", target41 text default \"0\", target42 text default \"0\", target43 text default \"0\") ");
//        insertdata1("0", "0", "0", "0", "0", "0", "0");
//        insertdata2("0", "0", "0", "0", "0", "0", "0");
//        insertdata3("0", "0", "0", "0", "0", "0", "0");
//        insertdata4("0", "0", "0", "0", "0", "0", "0");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + Tname1);
        db.execSQL(" DROP TABLE IF EXISTS " + Tname2);
        db.execSQL(" DROP TABLE IF EXISTS " + Tname3);
        db.execSQL(" DROP TABLE IF EXISTS " + Tname4);
        onCreate(db);
    }

    public boolean insertdata1(String ucapital1, String uprice1, String uQuantity1, String ustoploss1, String utarget11, String utarget12, String utarget13) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital1, ucapital1);
        contentValues.put(price1, uprice1);
        contentValues.put(Quantity1, uQuantity1);
        contentValues.put(stoploss1, ustoploss1);
        contentValues.put(target11, utarget11);
        contentValues.put(target12, utarget12);
        contentValues.put(target13, utarget13);

        long result = db.insert(Tname1, null, contentValues);
        return result != -1;
    }

    public boolean insertdata2(String ucapital2, String uprice2, String uQuantity2, String ustoploss2, String utarget21, String utarget22, String utarget23) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital2, ucapital2);
        contentValues.put(price2, uprice2);
        contentValues.put(Quantity2, uQuantity2);
        contentValues.put(stoploss2, ustoploss2);
        contentValues.put(target21, utarget21);
        contentValues.put(target22, utarget22);
        contentValues.put(target23, utarget23);

        long result = db.insert(Tname2, null, contentValues);
        return result != -1;
    }

    public boolean insertdata3(String ucapital3, String uprice3, String uQuantity3, String ustoploss3, String utarget31, String utarget32, String utarget33) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital3, ucapital3);
        contentValues.put(price3, uprice3);
        contentValues.put(Quantity3, uQuantity3);
        contentValues.put(stoploss3, ustoploss3);
        contentValues.put(target31, utarget31);
        contentValues.put(target32, utarget33);
        contentValues.put(target33, utarget33);

        long result = db.insert(Tname3, null, contentValues);
        return result != -1;
    }

    public boolean insertdata4(String ucapital4, String uprice4, String uQuantity4, String ustoploss4, String utarget41, String utarget42, String utarget43) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital4, ucapital4);
        contentValues.put(price4, uprice4);
        contentValues.put(Quantity4, uQuantity4);
        contentValues.put(stoploss4, ustoploss4);
        contentValues.put(target41, utarget41);
        contentValues.put(target42, utarget42);
        contentValues.put(target43, utarget43);

        long result = db.insert(Tname4, null, contentValues);
        return result != -1;
    }

    public HashMap getAllData1() {
        SQLiteDatabase db = getWritableDatabase();
        HashMap hm = new HashMap();
        Cursor res = db.rawQuery("select * from " + Tname1, null);
        res.moveToFirst();
        if(res.isAfterLast() || res.isBeforeFirst()) return  null;
        hm.put("capital1", res.getString(res.getColumnIndex("capital1")));
        hm.put("price1", res.getString(res.getColumnIndex("price1")));
        hm.put("Quantity1", res.getString(res.getColumnIndex("Quantity1")));
        hm.put("stoploss1", res.getString(res.getColumnIndex("stoploss1")));
        hm.put("target11", res.getString(res.getColumnIndex("target11")));
        hm.put("target12", res.getString(res.getColumnIndex("target12")));
        hm.put("target13", res.getString(res.getColumnIndex("target13")));

        res.close();
        return hm;
    }

    public HashMap getAllData2() {
        SQLiteDatabase db = getWritableDatabase();
        HashMap hm = new HashMap();
        Cursor res = db.rawQuery("select * from " + Tname2, null);
        res.moveToFirst();
        if(res.isAfterLast() || res.isBeforeFirst()) return  null;
        hm.put("capital2", res.getString(res.getColumnIndex("capital2")));
        hm.put("price2", res.getString(res.getColumnIndex("price2")));
        hm.put("Quantity2", res.getString(res.getColumnIndex("Quantity2")));
        hm.put("stoploss2", res.getString(res.getColumnIndex("stoploss2")));
        hm.put("target21", res.getString(res.getColumnIndex("target21")));
        hm.put("target22", res.getString(res.getColumnIndex("target22")));
        hm.put("target23", res.getString(res.getColumnIndex("target23")));

        res.close();
        return hm;
    }

    public HashMap getAllData3() {
        SQLiteDatabase db = getWritableDatabase();
        HashMap hm = new HashMap();
        Cursor res = db.rawQuery("select * from " + Tname3, null);
        res.moveToFirst();
        if(res.isAfterLast() || res.isBeforeFirst()) return  null;
        hm.put("capital3", res.getString(res.getColumnIndex("capital3")));
        hm.put("price3", res.getString(res.getColumnIndex("price3")));
        hm.put("Quantity3", res.getString(res.getColumnIndex("Quantity3")));
        hm.put("stoploss3", res.getString(res.getColumnIndex("stoploss3")));
        hm.put("target31", res.getString(res.getColumnIndex("target31")));
        hm.put("target32", res.getString(res.getColumnIndex("target32")));
        hm.put("target33", res.getString(res.getColumnIndex("target33")));

        res.close();
        return hm;
    }

    public HashMap getAllData4() {
        SQLiteDatabase db = getWritableDatabase();
        HashMap hm = new HashMap();
        Cursor res = db.rawQuery("select * from " + Tname4, null);
        res.moveToFirst();
        if(res.isAfterLast() || res.isBeforeFirst()) return  null;
        hm.put("capital4", res.getString(res.getColumnIndex("capital4")));
        hm.put("price4", res.getString(res.getColumnIndex("price4")));
        hm.put("Quantity4", res.getString(res.getColumnIndex("Quantity4")));
        hm.put("stoploss4", res.getString(res.getColumnIndex("stoploss4")));
        hm.put("target41", res.getString(res.getColumnIndex("target41")));
        hm.put("target42", res.getString(res.getColumnIndex("target42")));
        hm.put("target43", res.getString(res.getColumnIndex("target43")));

        res.close();
        return hm;
    }

    public boolean updateData1(String ucapital1, String uprice1, String uQuantity1, String ustoploss1, String utarget11, String utarget12, String utarget13) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital1, ucapital1);
        contentValues.put(price1, uprice1);
        contentValues.put(Quantity1, uQuantity1);
        contentValues.put(stoploss1, ustoploss1);
        contentValues.put(target11, utarget11);
        contentValues.put(target12, utarget12);
        contentValues.put(target13, utarget13);

        db.update(Tname1, contentValues, null,null);
        return true;
    }

    public boolean updateData2(String ucapital2, String uprice2, String uQuantity2, String ustoploss2, String utarget21, String utarget22, String utarget23) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital2, ucapital2);
        contentValues.put(price2, uprice2);
        contentValues.put(Quantity2, uQuantity2);
        contentValues.put(stoploss2, ustoploss2);
        contentValues.put(target21, utarget21);
        contentValues.put(target22, utarget22);
        contentValues.put(target23, utarget23);

        db.update(Tname2, contentValues, null,null);
        return true;
    }

    public boolean updateData3(String ucapital3, String uprice3, String uQuantity3, String ustoploss3, String utarget31, String utarget32, String utarget33) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital3, ucapital3);
        contentValues.put(price3, uprice3);
        contentValues.put(Quantity3, uQuantity3);
        contentValues.put(stoploss3, ustoploss3);
        contentValues.put(target31, utarget31);
        contentValues.put(target32, utarget33);
        contentValues.put(target33, utarget33);

        db.update(Tname3, contentValues, null,null);
        return true;
    }

    public boolean updateData4(String ucapital4, String uprice4, String uQuantity4, String ustoploss4, String utarget41, String utarget42, String utarget43) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(capital4, ucapital4);
        contentValues.put(price4, uprice4);
        contentValues.put(Quantity4, uQuantity4);
        contentValues.put(stoploss4, ustoploss4);
        contentValues.put(target41, utarget41);
        contentValues.put(target42, utarget42);
        contentValues.put(target43, utarget43);

        db.update(Tname4, contentValues, null,null);
        return true;
    }

    public Integer deleteData1() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Tname1, null, null);
    }

    public Integer deleteData2() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Tname2, null, null);
    }

    public Integer deleteData3() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Tname3, null, null);
    }

    public Integer deleteData4() {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(Tname4, null, null);
    }
}