package com.example.animora.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements Serializable {
    private String alamat;
    private String metodePembayaran;
    private List<Item> items;


    // Constructor tambahan
    public Customer(String name, String email, String password, String alamat, String metodePembayaran) {
        super(name, email, password);
        this.alamat = alamat;
        this.metodePembayaran = metodePembayaran;
        this.items = new ArrayList<>();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String newAlamat) {
        this.alamat = newAlamat;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String newMetodePembayaran) {
        this.metodePembayaran = newMetodePembayaran;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getAllItem() {
        return items;
    }
}