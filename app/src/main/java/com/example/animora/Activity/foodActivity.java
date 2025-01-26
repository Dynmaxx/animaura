package com.example.animora.Activity;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animora.ProductAdapter;
import com.example.animora.R;
import com.example.animora.database.ProductDatabase;
import com.example.animora.object.Product;

import java.util.ArrayList;
import java.util.List;

public class foodActivity extends AppCompatActivity {
    private ProductDatabase dbHelper;
    private RecyclerView recyclerView;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();
        dbHelper = new ProductDatabase(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(this, productList, product -> {

            // Handle product click for editing

        });
        recyclerView.setAdapter(productAdapter);
        loadProducts();

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