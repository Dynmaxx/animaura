package com.example.animora.object;

public class Customer extends User {
   private String alamat;

   /** @pdOid e0cd01c6-d7df-492a-89fe-f7f4b3b2896f */
   public Customer(String nama, String Password,String email) {
       super(nama, email, Password);

   }

   /** @pdOid 6cc7da0c-bfaf-4a4a-8e23-02fbd07a8d21 */
   public String getAlamat() {
      return alamat;
   }

   /** @param newAlamat
    * @pdOid 688caed2-4369-48e4-9a35-9a2667c39d6e */
   public void setAlamat(String newAlamat) {
      alamat = newAlamat;
   }

   /** @pdOid 6c874bbd-66f9-48cf-8242-bf35b25452ee */
   public void addItem() {
      // TODO: implement
   }

   /** @pdOid b9fa0229-9724-414e-a336-525d95d51234 */
   public void editItem() {
      // TODO: implement
   }

   /** @pdOid ef76d4e2-54f3-4895-ab4a-1225a2dad85c */
   public void deleteItem() {
      // TODO: implement
   }

   /** @pdOid 6b1eaad5-cb59-4bdc-95ce-3df7c18ee2ee */
   public Double getTotalItem() {
      // TODO: implement
      return null;
   }

   /** @pdOid 90996f70-c28e-49e0-9cb5-7386af8361df */
   public Object getAllItem() {
      // TODO: implement
      return null;
   }

}