package com.example.animora;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.object.User;
import com.example.animora.object.UserDatabase;

import java.util.ArrayList;

public class RegisterActivty extends AppCompatActivity {
    private ImageView back_reg;
    private TextView txt_log;
    private Button but_regis;
    private EditText namaregister;
    private EditText emailregister;
    private EditText confirmpass;
    private EditText passwordregister;
    private UserDatabase userDatabase;


//    DatabaseHelper dbhelper = new DatabaseHelper(this);
//    SQLiteDatabase db = dbhelper.getWritableDatabase();

    public static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();


        txt_log = findViewById(R.id.txt_log);
        back_reg = findViewById(R.id.back_reg);
        but_regis = findViewById(R.id.but_regis);
        namaregister = findViewById(R.id.nameregister);
        emailregister = findViewById(R.id.emailregister);
        passwordregister = findViewById(R.id.passwordregister);
        confirmpass = findViewById(R.id.confirmpass);

        but_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = namaregister.getText().toString();
                String email = emailregister.getText().toString();
                String password = passwordregister.getText().toString();
                String confpas = confirmpass.getText().toString();
                if (!password.equals(confpas)) {
                    Toast.makeText(RegisterActivty.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }
                userDatabase.registerUser (email, password);
                Toast.makeText(RegisterActivty.this, "User  registered!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivty.this, LoginActivity.class));
            }

        });
        back_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Backreg = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Backreg);
            }
        });
        txt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtlog = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(txtlog);
            }
        });
    }
    }