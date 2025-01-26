package com.example.animora.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animora.R;
import com.example.animora.database.ProductAdapter;
import com.example.animora.database.ProductDatabase;
import com.example.animora.object.Product;
import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private ProductDatabase dbHelper;
    private Button buttonAdd;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        dbHelper = new ProductDatabase(this);
        buttonAdd = findViewById(R.id.buttonAdd);
        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();

        // Register activity result launcher
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        loadProducts(); // Refresh the product list when returning from edit activity
                    }
                }
        );

        // Set up button to add a new product
        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, ProductEditActivity.class);
            activityResultLauncher.launch(intent); // Launch the activity for result
        });

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(this, productList, product -> {
            // Handle product click for editing
            Intent intent = new Intent(AdminActivity.this, ProductEditActivity.class);
            intent.putExtra("ProductId", product.getId());
            intent.putExtra("productName", product.getName());
            intent.putExtra("productPrice", product.getPrice());
            Log.d("saveProduct", "Send product: ID=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice());
            activityResultLauncher.launch(intent); // Launch the edit activity
        });
        recyclerView.setAdapter(productAdapter);
        loadProducts(); // Load products initially
    }

    private void loadProducts() {
        productList.clear();
        Cursor cursor = dbHelper.getAllProducts();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double price = cursor.getDouble(2);
                Log.d("database", "Name :" + name + " Price : " + price);
                productList.add(new Product(id, name, price));
            } while (cursor.moveToNext());
            cursor.close(); // Close cursor after use
        }
        productAdapter.notifyDataSetChanged(); // Notify adapter of data changes
    }
}