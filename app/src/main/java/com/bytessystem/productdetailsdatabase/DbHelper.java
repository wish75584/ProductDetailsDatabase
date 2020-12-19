package com.bytessystem.productdetailsdatabase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    //passing database name
    public static final String DATABASE_NAME = "category.db";

    //creating query for careting table with col names.
    private static final String SQL_CREATE_CATEGORY =
            "CREATE TABLE CATEGORY (cat1 TEXT,cat2 TEXT,cat3 TEXT,cat4 TEXT,cat5 TEXT)";




    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_CREATE_CATEGORY);
    }
}
