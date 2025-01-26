package com.example.animora.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animora.ProductAdapter;
import com.example.animora.R;
import com.example.animora.database.ProductDatabase;
import com.example.animora.object.Product;
import java.util.ArrayList;
import java.util.List;


public class AdminActivity extends AppCompatActivity{
    private ProductDatabase dbHelper;
    private EditText editTextName, editTextPrice;
    private Button buttonAdd, buttonView;
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        dbHelper = new ProductDatabase(this);
        buttonAdd = findViewById(R.id.buttonAdd);
        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();


        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // Handle the result here
                        loadProducts(); // Refresh the product list or handle the result
                    }
                }
        );

        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, ProductEditActivity.class);
            activityResultLauncher.launch(intent); // Launch the activity for result
            loadProducts();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(this, productList, product -> {

            // Handle product click for editing
            Intent intent = new Intent(AdminActivity.this, ProductEditActivity.class);
            intent.putExtra("ProductId", product.getId());
            intent.putExtra("productName", product.getName());
            intent.putExtra("productPrice", product.getPrice());
            Log.d("saveProduct", "Send product: ID=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice());
            activityResultLauncher.launch(intent);

            // You can also add a method to update the product in the database
            loadProducts();

        });
        recyclerView.setAdapter(productAdapter);
        loadProducts();
    }

    private void loadProducts() {
        productList.clear();
//        productList.add(new Product(1, "Sample Product 1", 10.0));
//        productList.add(new Product(2, "Sample Product 2", 20.0));
        Cursor cursor = dbHelper.getAllProducts();
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double price = cursor.getDouble(2);
                Log.d("database","Name :"+name+" Price : "+price);
                productList.add(new Product(id, name, price));
            } while (cursor.moveToNext());
        }
        cursor.close();

        productAdapter.notifyDataSetChanged();
    }
}