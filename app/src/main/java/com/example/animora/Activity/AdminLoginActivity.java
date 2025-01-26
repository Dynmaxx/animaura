package com.example.animora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animora.R;
import com.example.animora.object.Admin;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText userEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        userEditText = findViewById(R.id.adminlogin);
        passwordEditText = findViewById(R.id.passwordadmin);
        loginButton = findViewById(R.id.adminlog);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!name.isEmpty() && !password.isEmpty()) {
                    Admin admin = new Admin("", name, "", "");
                    if (admin.login(AdminLoginActivity.this, name, password)) {
                        Toast.makeText(AdminLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(getApplicationContext(),AdminActivity.class);
                        startActivity(in);
                        // Arahkan ke aktivitas berikutnya
                    } else {
                        Toast.makeText(AdminLoginActivity.this, "Invalid name or password ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AdminLoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}