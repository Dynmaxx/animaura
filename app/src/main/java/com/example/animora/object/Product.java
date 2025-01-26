package com.example.animora.object;

/** @pdOid a16950f6-d9fd-4db1-8c86-1bc6e679e893 */
public class Product {
   /** @pdOid 22862253-6b74-4c06-bd99-91fce203cb83 */
   private long id;
   /** @pdOid 275eb93e-3f25-4144-a824-cf0082a123f0 */
   private String name;
   /** @pdOid d6229707-31e5-41be-aa8d-4b3c56cf8827 */
   private double price;
   /** @pdOid 67335774-e35f-435e-a9ac-b264ccdb12cf */
   private String category;
   /** @pdOid 67ffbff6-7cf1-4b2f-91c2-858d2e263bef */
   private String description;
   /** @pdOid 67ffbff6-7cf1-4b2f-91c2-858d2e263bef */
   private String image;

   /** @pdOid 69aaec74-d944-4e0d-b63f-e38739bd8fba */
   public Product(long id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
   }

   /** @pdOid c082136d-f0d7-411d-93ae-a5c5260ec590 */
   public long getId() {
      return id;
   }

   /** @param newId
    * @pdOid 5195c682-3288-4d54-831d-e3d91f0cb308 */
   public void setId(long newId) {
      id = newId;
   }

   /** @pdOid e0909028-ec2e-45f9-80b9-861738d458e6 */
   public String getName() {
      return name;
   }

   /** @param newName
    * @pdOid 8be05c2b-7947-48b1-8b1f-877dc424b075 */
   public void setName(String newName) {
      name = newName;
   }

   /** @pdOid 1782490a-fdee-4b04-b88e-a2d4781ccc9a */
   public double getPrice() {
      return price;
   }

   /** @param newPrice
    * @pdOid 952de6a5-8816-4abe-9542-a6f3880c5812 */
   public void setPrice(double newPrice) {
      price = newPrice;
   }

   /** @pdOid 8d49e56c-edbd-40f3-8525-4af442f33539 */
   public String getCategory() {
      return category;
   }

   /** @param newCategory
    * @pdOid 805a005d-01fd-4402-9f6e-67241379b7b5 */
   public void setCategory(String newCategory) {
      category = newCategory;
   }

   /** @pdOid 5abbce6e-3da8-4105-a892-02f2ccf4dd9f */
   public String getDescription() {
      return description;
   }

   /** @param newDescription
    * @pdOid 751cac6f-042a-4317-9fdb-5aaee8b9cded */
   public void setDescription(String newDescription) {
      description = newDescription;
   }
   /** @pdOid 5abbce6e-3da8-4105-a892-02f2ccf4dd9f */
   public String getImage() {
      return image;
   }

}