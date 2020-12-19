package com.bytessystem.productdetailsdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper2 extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;

    public static final String DATABASE_NAME = "product.db";

    private static final String CREATE_TABLE = "CREATE TABLE PRODUCTS (pname TEXT,pprice TEXT,pcategory TEXT,pdescription  TEXT )";



    public DbHelper2(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(CREATE_TABLE);
    }
}
