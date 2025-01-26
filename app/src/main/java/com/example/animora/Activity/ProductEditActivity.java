package com.example.animora.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animora.R;
import com.example.animora.database.ProductDatabase;

public class ProductEditActivity extends AppCompatActivity{
    private EditText editTextName, editTextPrice;
    private Button buttonSave, buttonCancel, buttonDelete,buttonSelectImage;
    private ProductDatabase dbHelper;
    private int productId = -1;
//    private static final int PICK_IMAGE_REQUEST = 1;
//    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        dbHelper = new ProductDatabase(this);
        editTextName = findViewById(R.id.editTextName);
        editTextPrice = findViewById(R.id.editTextPrice);
        buttonSave = findViewById(R.id.buttonSave);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonSelectImage = findViewById(R.id.buttonSelectImage);

        // Check if we are editing an existing product
        Intent intent = getIntent();
        if (intent.hasExtra("ProductId")) {

            productId = Math.toIntExact(intent.getLongExtra("ProductId",-1));
            String name = intent.getStringExtra("productName");
            double price = intent.getDoubleExtra("productPrice", 0.0);
            editTextName.setText(name);
            editTextPrice.setText(String.valueOf(price));

            if(productId != -1){
                buttonDelete.setVisibility(View.VISIBLE);
            }

        }
//        buttonSelectImage.setOnClickListener(v -> openGallery());

        buttonSave.setOnClickListener(v -> saveProduct());
        buttonCancel.setOnClickListener(v -> finish());
        buttonDelete.setOnClickListener(v -> deleteProduct());
    }

//    private void openGallery() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData(); // Get the image URI
//            // You can display the selected image in an ImageView if you have one
//        }
//    }

    private void saveProduct() {
        String name = editTextName.getText().toString();
        double price;

        try {
            price = Double.parseDouble(editTextPrice.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid price", Toast.LENGTH_SHORT).show();
            return;
        }

        if (productId == -1) {
            // Adding a new product
            dbHelper.addProduct(name, price, "");
            Toast.makeText(this, "Product added", Toast.LENGTH_SHORT).show();
        } else {

            // Editing an existing product
            dbHelper.updateProduct(productId, name, price);
            Toast.makeText(this, "Product updated", Toast.LENGTH_SHORT).show();
        }

        setResult(RESULT_OK);
        finish(); // Close the activity
    }
    private void deleteProduct() {
        if (productId != -1) {
            dbHelper.deleteProduct(productId); // Call the delete method from your database helper
            Toast.makeText(this, "Product deleted", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
        } else {
            Toast.makeText(this, "No product to delete", Toast.LENGTH_SHORT).show();
        }
        finish(); // Close the activity after deletion
    }

}