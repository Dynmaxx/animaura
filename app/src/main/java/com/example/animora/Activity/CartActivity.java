package com.example.animora.Activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animora.R;
import com.example.animora.Service.OrderService;
import com.example.animora.database.AddressManager;
import com.example.animora.database.ProductAdapter;
import com.example.animora.object.Product;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private TextView txt_address, txt_payment_method, addedit, price,tax,total;
    private ImageView cart_back;
    private AddressManager addressManager;
    private RecyclerView recyclerView;
    private List<Product> productList;
    private ProductAdapter productAdapter;
    private OrderService orderService;
    private boolean isBound = false;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            OrderService.MyBinder binder = (OrderService.MyBinder) service;
            orderService = binder.getService();
            isBound = true;
            loadProductsFromService(); // Load products when service is connected
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        txt_address = findViewById(R.id.addres_text);
        txt_payment_method = findViewById(R.id.Cashpay);
        cart_back = findViewById(R.id.cart_back);
        price = findViewById(R.id.pricesb);
        tax = findViewById(R.id.pricetax);
        total = findViewById(R.id.PriceTotal);

        addressManager = new AddressManager(this);
        loadCustomerData(); // Load customer data when the activity starts

        cart_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent); // Close the CartActivity to return to the previous activity
                finish();
            }
        });

        addedit = findViewById(R.id.edit_add);
        addedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(), AddresActivity.class);
                startActivity(inte);
            }
        });

        recyclerView = findViewById(R.id.recyclerView_cart);
        productList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(this, productList, product -> {
            productList.remove(product);
            if (isBound && orderService != null) {
                orderService.deleteProductList(product);
            }
            productAdapter.notifyDataSetChanged();
            updateTotalPrice();
            updateTotalTax();
            updateTotalTotal();
        });
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OrderService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    private void loadCustomerData() {
        String[] existingCustomerInfo = addressManager.getCustomerInfo();
        txt_address.setText("Address: " + existingCustomerInfo[0]);
        txt_payment_method.setText("Payment Method: " + existingCustomerInfo[1]);
    }

    private void loadProductsFromService() {
        if (isBound && orderService != null) {
            productList.clear();
            productList.addAll(orderService.getProductList());
            productAdapter.notifyDataSetChanged();
            updateTotalPrice();
            updateTotalTax();
            updateTotalTotal();
        }
    }

    private void updateTotalPrice() {
        if (isBound && orderService != null) {
            double totalPrice = getTotalPrice(); // Calculate total price
            price.setText(String.format("SubTotal Price: $%.2f", totalPrice)); // Update the TextView
        }
    }

    private void updateTotalTax() {
        if (isBound && orderService != null) {
            double totalPrice = getTotalPrice(); // Calculate total price
            tax.setText(String.format("Total Tax: $%.2f", totalPrice*0.05)); // Update the TextView
        }
    }


    private void updateTotalTotal() {
        if (isBound && orderService != null) {
            double totalPrice = getTotalPrice();
            double totaltax = getTotalPrice()*0.05;
            total.setText(String.format("Total Price: $%.2f", totalPrice+totaltax)); // Update the TextView
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}