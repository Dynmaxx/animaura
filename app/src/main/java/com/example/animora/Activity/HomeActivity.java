package com.example.animora.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animora.R;
import com.example.animora.Service.OrderService;
import com.example.animora.database.ProductAdapter;
import com.example.animora.database.ProductDatabase;
import com.example.animora.database.UserDatabase;
import com.example.animora.object.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private TextView txt_user;
    private UserDatabase userDatabase;
    private ImageView btn_animal, acc_button, btn_food, btn_home, btn_cart;
    private Button contanct;
    private ProductDatabase dbHelper;
    private RecyclerView recyclerView;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        getSupportActionBar().hide();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }



        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();
        dbHelper = new ProductDatabase(this);

        txt_user = findViewById(R.id.txt_user);
        userDatabase = new UserDatabase(this);

        String username = getIntent().getStringExtra("USERNAME");
        if (username != null) {
            txt_user.setText(" " + username);
        } else {
            txt_user.setText("User  not found");
        }

        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();
        dbHelper = new ProductDatabase(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(this, productList, product -> {
            // Create an Intent to start the service
            Intent serviceIntent = new Intent(HomeActivity.this, OrderService.class);

            // Create a new Product object to send
            Product productData = new Product(product.getId(), product.getName(), product.getPrice());

            // Put the product data into the Intent
            serviceIntent.putExtra("product_data", productData);

            // Start the service
            startService(serviceIntent);

            Log.d("saveProduct", "Sent product to service: ID=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice());
        });
        recyclerView.setAdapter(productAdapter);
        loadProducts();


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

    private void loadProducts() {
        productList.clear();
        Cursor cursor = dbHelper.getAllProducts();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double price = cursor.getDouble(2);
                productList.add(new Product(id, name, price));
            } while (cursor.moveToNext());
        }
        cursor.close();

        productAdapter.notifyDataSetChanged();
    }
}