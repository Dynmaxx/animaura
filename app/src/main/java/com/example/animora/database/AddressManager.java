package com.example.animora.database;

import android.content.Context;
import android.content.SharedPreferences;

public class AddressManager {
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "customer_preferences";

    public AddressManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Save or update customer information
    public void insertCustomerInfo(String address, String paymentMethod) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("customer_address", address);
        editor.putString("customer_payment_method", paymentMethod);
        editor.apply(); // Save the changes
    }

    // Get the saved address and payment method
    public String[] getCustomerInfo() {
        String address = sharedPreferences.getString("customer_address", "No address set");
        String paymentMethod = sharedPreferences.getString("customer_payment_method", "No payment method set");
        return new String[] { address, paymentMethod };
    }

    // Optionally, you can add a method to clear the saved data
    public void clearCustomerInfo() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Clear all saved customer data
        editor.apply();
    }
}