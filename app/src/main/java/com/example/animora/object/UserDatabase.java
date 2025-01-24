package com.example.animora.object;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USERS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT UNIQUE, password TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public boolean registerUser (String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1; // return true if insert was successful
    }

    public boolean validateUser (String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE email = ? AND password = ?", new String[]{email, password});
        boolean isValid = cursor.getCount() > 0;
        cursor.close();
        return isValid;
    }
}