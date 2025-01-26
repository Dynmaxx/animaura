package com.example.animora.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "animora.db";
    private static final int DATABASE_VERSION = 1;

    public AdminHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Buat tabel admin
        String CREATE_ADMIN_TABLE = "CREATE TABLE admin (id TEXT PRIMARY KEY, name TEXT, email TEXT, password TEXT)";
        db.execSQL(CREATE_ADMIN_TABLE);

        // Tambahkan admin default (hanya untuk contoh)
        String insertDefaultAdmin = "INSERT INTO admin (id, name, email, password) VALUES ('1', 'Admin', 'admin@example.com', 'admin123')";
        db.execSQL(insertDefaultAdmin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS admin");
        onCreate(db);
    }
}