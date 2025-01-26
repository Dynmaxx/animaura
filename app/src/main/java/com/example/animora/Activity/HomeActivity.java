package com.example.animora.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.R;
import com.example.animora.database.UserDatabase;

public class HomeActivity extends AppCompatActivity {
    private TextView txt_user;
    private UserDatabase userDatabase;
    private ImageView btn_animal, acc_button, btn_food, btn_home, btn_cart;
    private Button contanct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        txt_user = findViewById(R.id.txt_user);
        userDatabase = new UserDatabase(this);
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null) {
            txt_user.setText(" " + username);
        } else {
            txt_user.setText("User  not found");
        }
        contanct = findViewById(R.id.contanct);
        contanct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp("087815693767", "Hello!");
            }
        });
        btn_food = findViewById(R.id.btn_food);
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnfood = new Intent(getApplicationContext(), foodActivity.class);
                startActivity(btnfood);
            }
        });
        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnhome = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(btnhome);
            }
        });
        btn_cart = findViewById(R.id.btn_cart);
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btncart = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(btncart);
            }
        });
    }
    private void openWhatsApp(String phoneNumber, String message) {
        // Create the URL for WhatsApp
        String url = "https://www.instagram.com/beru_101/" + phoneNumber + "?text=" + Uri.encode(message);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        // Start the activity without checking if WhatsApp is installed
        startActivity(intent);
    }
}