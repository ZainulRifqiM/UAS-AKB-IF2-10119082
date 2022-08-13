package com.zainulrifqi.uasakbif_210119082.ui.gallery;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_catatan";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE catatan(no integer primary key,tanggal text null, judul text null, kategori text null, isi text null);";
        Log.d("Data","onCreate"+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
