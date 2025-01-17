package com.example.animora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    ImageView back_log;
    TextView txt_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView : back_log = findViewById(R.id.back_log);
        getSupportActionBar().hide();
        back_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backlog = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(backlog);
            }
        });
        TextView : txt_reg = findViewById(R.id.txt_reg);
        txt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtreg = new Intent(getApplicationContext(),RegisterActivty.class);
                startActivity(txtreg);
            }
        });
    }
}