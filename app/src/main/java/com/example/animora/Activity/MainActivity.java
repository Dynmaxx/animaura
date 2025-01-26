package com.example.animora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.R;

public class MainActivity extends AppCompatActivity {
Button btnlogin,btnregister,btnadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnregister = (Button) findViewById(R.id.btnregister);
        btnadmin = (Button) findViewById(R.id.btnadmin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogButton = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(LogButton);
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegister();
            }
        });
        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(getApplicationContext(), AdminLoginActivity.class);
                startActivity(admin);
            }
        });
    }
    public void btnRegister() {
        Intent LogRegister = new Intent(getApplicationContext(), RegisterActivty.class);
        startActivity(LogRegister);
}

}