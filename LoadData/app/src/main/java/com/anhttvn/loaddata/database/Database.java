package com.anhttvn.loaddata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.anhttvn.loaddata.config.Config;
import com.anhttvn.loaddata.model.Alphabet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huu Duan on 8/17/2016.
 * @author anhtt
 */
public class Database {
    private SQLiteDatabase mDb;
    private SQL mSQL;

    public SQL getOpen(){
        return mSQL;
    }
    public Database(Context context){
        mSQL = new SQL(context);
    }

    /**
     * open Sql
     */
    private void open() {
        try {
            mDb = mSQL.getWritableDatabase();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    /**
     * Close database
     */
    private void close() {
        mSQL.close();
    }
    public void addAlphabet(Alphabet alphabet){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Config.AB_hiragata,alphabet.getHigarata());
        contentValues.put(Config.AB_kagarana,alphabet.getKatagana());
        contentValues.put(Config.VN_hika,alphabet.getVn_hiragata_katagana());
        try{
            open();
            mDb.insert(Config.TABEL_AB,null,contentValues);

        }catch (SQLException e){
            e.getMessage();
        }
        close();
    }
    public List<Alphabet> getList(){
        List<Alphabet> list = new ArrayList<>();
        String SQL ="SELECT * FROM " + Config.TABEL_AB;
        try{
            open();
            Cursor cursor = mDb.rawQuery(SQL, null);
            if(cursor.getCount() == 0){
                close();
                return null;
            }else{
                cursor.moveToFirst();
                do{
                    Alphabet alphabet = new Alphabet();
                    alphabet.setId(cursor.getInt(0));
                    alphabet.setHigarata(cursor.getString(1));
                    alphabet.setKatagana(cursor.getString(2));
                    alphabet.setVn_hiragata_katagana(cursor.getString(3));
                    list.add(alphabet);
                }while (cursor.moveToNext());
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return list;
    }

}
