package com.example.animora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.R;
import com.example.animora.database.UserDatabase;

public class RegisterActivty extends AppCompatActivity {
    private ImageView back_reg;
    private TextView txt_log;
    private Button but_regis;
    private EditText namaregister;
    private EditText emailregister;
    private EditText confirmpass;
    private EditText passwordregister;
    private UserDatabase userDatabase;

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
        userDatabase = new UserDatabase(this);

        but_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = namaregister.getText().toString();
                String email = emailregister.getText().toString();
                String password = passwordregister.getText().toString();
                String confirmPassword = confirmpass.getText().toString();

                // Validasi input
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivty.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivty.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mendaftar pengguna
                if (userDatabase.registerUser (username, email, password)) {
                    Toast.makeText(RegisterActivty.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivty.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegisterActivty.this, "Registration failed! Email or username may already exist.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Backreg = new Intent(RegisterActivty.this, MainActivity.class);
                startActivity(Backreg);
            }
        });

        txt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtlog = new Intent(RegisterActivty.this, LoginActivity.class);
                startActivity(txtlog);
            }
        });
    }
}