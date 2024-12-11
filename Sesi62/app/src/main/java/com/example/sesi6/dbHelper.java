package com.example.sesi6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_CONTACT = "CONTACT";
    public static final String FIELD_NAME = "contact_name";
    public static final String FIELD_Phone = "contact_phone";
    public static final String FIELD_ID = "id";

    public dbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_CONTACT +"("
                + FIELD_ID + "INTEGER PRIMARY KEY,"
                + FIELD_NAME + "TEXT"
                + FIELD_Phone + "TEXT";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
    }
}
