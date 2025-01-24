package com.example.animora;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.object.Customer;
import com.example.animora.object.User;
import com.example.animora.object.UserDatabase;

public class LoginActivity extends AppCompatActivity {
    private ImageView back_log;
    private TextView txt_reg;
    private Button but_log;
    private EditText emaillogin;
    private EditText passwordlogin;

    private DatabaseHelper dbHelper = new DatabaseHelper(this);
    private UserDatabase UserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView:
        back_log = findViewById(R.id.back_log);
        getSupportActionBar().hide();

        emaillogin = findViewById(R.id.emaillogin);
        passwordlogin = findViewById(R.id.passwordlogin);
        but_log = findViewById(R.id.but_log);
        UserDatabase = new UserDatabase(this);

        but_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emaillogin.getText().toString();
                String password = passwordlogin.getText().toString();

                if (UserDatabase.loginUser (email, password)) {
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // Navigate to the next activity
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}