package com.example.animora.object;
import java.util.ArrayList;
import java.util.List;
public class User {
   private String id;
   private String name;
   private String email;
   private String password;
   private static List<User> userList = new ArrayList<>();


   public User(String name,String email,String password) {
      this.name = name;
      this.email = email;
      this.password = password;
      userList.add(this);
   }

   public static boolean validateUser (String email, String password) {
      for (User  user : userList) {
         if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return true;
         }
      }
      return false;
   }

   public String getId() {
      return id;
   }
   public void setId(String newId) {

      id = newId;
   }
   
   /** @pdOid 00dce929-1ab4-480f-85d1-3e3bd5cf5152 */
   public String getName() {
      return name;
   }
   
   /** @param newName
    * @pdOid dc17ef01-5eb3-483e-b6ec-5613d661f321 */
   public void setName(String newName) {

      this.name = newName;
   }
   
   /** @pdOid 28d2d391-b7d0-4b9d-90e8-79c30ddb3b9c */
   public String getEmail() {

      return email;
   }
   
   /** @param newEmail
    * @pdOid 65ff06c9-f7bc-4ac7-a3c8-4e179ac94304 */
   public void setEmail(String newEmail) {
      this.email = newEmail;
   }
   
   /** @pdOid cba5ad8c-7e77-47cb-b712-a4d23705a686 */
   public String getPassword() {
      return password;
   }
   
   /** @param newPassword
    * @pdOid 47f40f2e-67ab-4d9a-9b3f-117e9add8843 */
   public void setPassword(String newPassword) {

      this.password = newPassword;
   }

}