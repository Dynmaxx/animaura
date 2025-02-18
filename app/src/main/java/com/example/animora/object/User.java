package com.example.animora.object;

public class User {
   private String id; // ID pengguna
   private String name; // Nama pengguna
   private String email; // Email pengguna
   private String password; // Password pengguna

   // Constructor
   public User(String id, String name, String email, String password) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.password = password;
   }
   // Constructor ke 2 (overloading constructor)
   public User(String name, String email, String password) {
      this.name = name;
      this.email = email;
      this.password = password;
      // id bisa diatur ke nilai default atau dihasilkan secara otomatis
      this.id = generateId(); // Misalnya, metode untuk menghasilkan ID
   }

   // Metode untuk menghasilkan ID (contoh)
   private String generateId() {
      // Logika untuk menghasilkan ID
      return "default-id"; // Ganti dengan logika yang sesuai
   }

   // Getter dan Setter untuk ID
   public String getId() {
      return id;
   }

   public void setId(String newId) {
      this.id = newId;
   }

   // Getter dan Setter untuk Nama
   public String getName() {
      return name;
   }

   public void setName(String newName) {
      this.name = newName;
   }

   // Getter dan Setter untuk Email
   public String getEmail() {
      return email;
   }

   public void setEmail(String newEmail) {
      this.email = newEmail;
   }

   // Getter dan Setter untuk Password
   public String getPassword() {
      return password;
   }

   public void setPassword(String newPassword) {
      this.password = newPassword;
   }
}