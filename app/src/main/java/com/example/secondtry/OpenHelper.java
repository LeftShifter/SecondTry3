package com.example.secondtry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceFragment;

class OpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "chubriki.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CHUBRIKS_TABLE_NAME = "chubriki";
    private static final String CHUBRIKS_GEN_TABLE_NAME="chubriks_gen";
    private static final String GENS_TABLE_NAME="gens";

    // Название столбцов
    private static final String COLUMN_ID = "chubrik_id";
    private static final String NAME = "name";
    private static final String COLUMN_GEN_ID  = "gen_id";
    private static final String COLUMN_IMAGEID = "image_id";

    // Номера столбцов





    OpenHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); }
    @Override
    public void onCreate( SQLiteDatabase db) {
        String query = "CREATE TABLE " + CHUBRIKS_TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +"String, "+
                COLUMN_IMAGEID + " INTEGER "  + "); ";
        db.execSQL(query);
         query = "CREATE TABLE " + CHUBRIKS_GEN_TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +"String, "+
                COLUMN_ID   + " INTEGER"+ "); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
}