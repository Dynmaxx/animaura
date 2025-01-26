package com.example.animora.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.animora.R;
import com.example.animora.database.AddressManager;

public class AddresActivity extends AppCompatActivity {
    private EditText edit_add;
    private Button button_add;
    private TextView txt_cash, txt_mandiri, txt_bca, txt_bni;

    private AddressManager addressManager;
    private String selectedPaymentMethod = ""; // Selected payment method

    private String initialAddress; // Store initial address
    private String initialPaymentMethod; // Store initial payment method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addres);
        getSupportActionBar().hide();

        edit_add = findViewById(R.id.edit_add);
        button_add = findViewById(R.id.button_add);
        txt_bni = findViewById(R.id.txt_bni);
        txt_mandiri = findViewById(R.id.txt_mandiri);
        txt_bca = findViewById(R.id.txt_bca);
        txt_cash = findViewById(R.id.txt_cash);

        addressManager = new AddressManager(this);
        initializeCustomerInformation();

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = edit_add.getText().toString();

                if (!address.isEmpty() && !selectedPaymentMethod.isEmpty()) {
                    // Save the new customer data
                    addressManager.insertCustomerInfo(address, selectedPaymentMethod);
                    Toast.makeText(AddresActivity.this, "Address saved successfully!", Toast.LENGTH_SHORT).show();

                    // Reset fields after saving
                    edit_add.setText(""); // Clear the address field
                    selectedPaymentMethod = ""; // Reset the selected payment method
                    initializeCustomerInformation(); // Reload initial data

                    // Return to CartActivity
                    Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AddresActivity.this, "Please enter address and select payment method", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up listeners for payment methods
        setPaymentMethodClickListener(txt_cash, "Cash");
        setPaymentMethodClickListener(txt_mandiri, "Bank Mandiri");
        setPaymentMethodClickListener(txt_bca, "Bank BCA");
        setPaymentMethodClickListener(txt_bni, "Bank BNI");
    }

    private void setPaymentMethodClickListener(TextView textView, String paymentMethod) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPaymentMethod = paymentMethod;
                displaySelectedPaymentMethod();
                Toast.makeText(AddresActivity.this, "Selected: " + selectedPaymentMethod, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displaySelectedPaymentMethod() {
        txt_cash.setText("Cash");
        txt_mandiri.setText("Mandiri");
        txt_bca.setText("BCA");
        txt_bni.setText("BNI");

        switch (selectedPaymentMethod) {
            case "Cash":
                txt_cash.setText("Selected Payment Method: Cash");
                break;
            case "Bank Mandiri":
                txt_mandiri.setText("Selected Payment Method: Bank Mandiri");
                break;
            case "Bank BCA":
                txt_bca.setText("Selected Payment Method: Bank BCA");
                break;
            case "Bank BNI":
                txt_bni.setText("Selected Payment Method: Bank BNI");
                break;
        }
    }

    private void initializeCustomerInformation() {
        String[] existingCustomerInfo = addressManager.getCustomerInfo();
        // Pre-fill address field if there is existing data
        if (!existingCustomerInfo[0].equals("No address set")) {
            edit_add.setText(existingCustomerInfo[0]);
            initialAddress = existingCustomerInfo[0]; // Store the initial address
            initialPaymentMethod = existingCustomerInfo[1]; // Store the initial payment method
            displaySelectedPaymentMethod();
        }
    }
}