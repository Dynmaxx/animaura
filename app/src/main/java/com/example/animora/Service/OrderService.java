package com.example.animora.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.animora.object.Product;

import java.util.ArrayList;

public class OrderService extends Service {
    private ArrayList<Product> productList = new ArrayList<>();
    private final IBinder binder = new MyBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Retrieve the product data from the Intent
        Product product = intent.getParcelableExtra("product_data");

        if (product != null) {
            // Add the product to the ArrayList
            productList.add(product);
            Log.d("MyService", "Product added: ID=" + product.getId() + ", Name=" + product.getName() + ", Price=" + product.getPrice());
        }

        return START_STICKY; // Service will be restarted if killed
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder; // We don't need to bind this service
    }

    // Method to retrieve the product list
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void deleteProductList(Product product){
        productList.remove(product);
    }

    public class MyBinder extends Binder {
        public OrderService getService() { // Changed to public
            return OrderService.this;
        }
    }
}