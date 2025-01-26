package com.example.animora.object;

public class Customer {
    private String name;
    private String address;
    private String paymentMethod;

    public Customer(String name, String address, String paymentMethod) {
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}