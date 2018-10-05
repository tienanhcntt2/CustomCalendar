package com.anhttvn.loaddata.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anhttvn.loaddata.config.Config;

/**
 * Created by Huu Duan on 8/17/2016.
 * @author anhtt
 */
public class SQL extends SQLiteOpenHelper {
    public SQL(Context context){
        super(context, Config.DATA_NAME,null,Config.DATA_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Config.CREATE_TB);
            db.execSQL(Config.CREATE_TB_CD);
            db.execSQL(Config.CREATE_TB_TV);
        }catch (SQLException e){
            e.getMessage();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Config.TABEL_AB);
        db.execSQL("DROP TABLE IF EXISTS " +Config.TABEL_ChuDe);
        db.execSQL("DROP TABLE IF EXISTS " +Config.CREATE_TB_TV);
        onCreate(db);
    }
}
