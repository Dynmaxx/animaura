package com.example.animora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class RegisterActivty extends AppCompatActivity {
ImageView back_reg;
TextView txt_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        ImageView : back_reg = findViewById(R.id.back_reg);
        back_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backreg = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(backreg);
            }
        });
        TextView :txt_log = findViewById(R.id.txt_log);
        txt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtlog = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(txtlog);
            }
        });
    }
}