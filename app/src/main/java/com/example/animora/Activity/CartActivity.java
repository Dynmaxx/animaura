package com.example.animora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.animora.R;
import com.example.animora.database.AddressManager;

public class CartActivity extends AppCompatActivity {
    private TextView txt_address, txt_payment_method,addedit;
    private ImageView cart_back;
    private AddressManager addressManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        txt_address = findViewById(R.id.addres_text);
        txt_payment_method = findViewById(R.id.Cashpay);
        cart_back = findViewById(R.id.cart_back);

        addressManager = new AddressManager(this);
        loadCustomerData(); // Load customer data when the activity starts

        cart_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);// Close the CartActivity to return to the previous activity
            }
        });
        addedit = findViewById(R.id.edit_add);
        addedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(),AddresActivity.class);
                startActivity(inte);
            }
        });
    }

    private void loadCustomerData() {
        String[] existingCustomerInfo = addressManager.getCustomerInfo();
        txt_address.setText("Address: " + existingCustomerInfo[0]);
        txt_payment_method.setText("Payment Method: " + existingCustomerInfo[1]);
    }
}