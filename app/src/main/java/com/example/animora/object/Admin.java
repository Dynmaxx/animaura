package com.example.animora.object;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.animora.database.AdminHelper;
import com.example.animora.database.DatabaseHelper;

public class Admin extends User {
    public Admin(String id, String name, String password, String email) {
        super(id, name, email, password);
    }

    public boolean login(Context context, String name, String password) {
        AdminHelper adminHelper = new AdminHelper(context);
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        String query = "SELECT password FROM admin WHERE name = ?";
        Cursor cursor = db.rawQuery(query, new String[]{name});

        boolean isLoggedIn = false;
        if (cursor.moveToFirst()) {
            String storedPassword = cursor.getString(0);
            isLoggedIn = password.equals(storedPassword);
        }
        cursor.close();
        db.close();
        return isLoggedIn;
    }


    // Metode lain untuk menambah, mengedit, dan menghapus produk
    public void addProduct() {
        // Implementasi menambah produk
    }

    public void editProduct() {
        // Implementasi mengedit produk
    }

    public void deleteProduct() {
        // Implementasi menghapus produk
    }

    public void getListProduct() {
        // Implementasi mendapatkan daftar produk
    }
}