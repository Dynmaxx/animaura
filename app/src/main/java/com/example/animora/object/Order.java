//package com.example.animora; /***********************************************************************
// * Module:  Order.java
// * Author:  desma23
// * Purpose: Defines the Class Order
// ***********************************************************************/
//
//import java.util.*;
//
///** @pdOid 94d53dbc-5bca-40b2-8075-77443e2e1bb4 */
//public class Order {
//   /** @pdOid b4420ce2-7fef-4032-844f-f15c84947796 */
//   private long id;
//   /** @pdOid f12db918-fa12-45a5-8539-ba75355e7f49 */
//   private Object item;
//   /** @pdOid 58879610-8743-4455-b3be-28d3ca6e805a */
//   private double total;
//   /** @pdOid 6ee4aab9-e785-4421-8755-45e569fc3538 */
//   private Object customer;
//
//   /** @pdRoleInfo migr=no name=Customer assc=orderKeCustomer coll=java.util.Collection impl=java.util.HashSet mult=* */
//   public Collection<Customer> Mengorder;
//   /** @pdRoleInfo migr=no name=Product assc=orderKeProduk coll=java.util.Collection impl=java.util.HashSet mult=* */
//
//
//   /** @pdOid 6960c2d7-36c5-4f38-ad39-039c045f3deb */
//   public Order() {
//      // TODO: implement
//   }
//
//   /** @pdOid d3a5b8b6-1229-4149-8082-46e1ba281218 */
//   public long getId() {
//      return id;
//   }
//
//   /** @param newId
//    * @pdOid dd4570df-b690-42a8-81ba-cdc7217caae8 */
//   public void setId(long newId) {
//      id = newId;
//   }
//
//   /** @pdOid eac73bb1-b21d-4df7-83d0-125381e4d8f6 */
//   public Object getItem() {
//      return item;
//   }
//
//   /** @param newItem
//    * @pdOid 1c7980ce-8503-4af1-b055-551d711ef0ff */
//   public void setItem(Object newItem) {
//      item = newItem;
//   }
//
//   /** @pdOid eb3b3812-4187-4c17-adfe-a2c3c5ca1bde */
//   public double getTotal() {
//      return total;
//   }
//
//   /** @param newTotal
//    * @pdOid c925c1c0-4ac3-4bdc-9dff-a313043c7fc4 */
//   public void setTotal(double newTotal) {
//      total = newTotal;
//   }
//
//   /** @pdOid 307828e8-1f8d-4731-a369-7ee8d7b06d02 */
//   public Object getCustomer() {
//      return customer;
//   }
//
//   /** @param newCustomer
//    * @pdOid 6e5d4072-98b0-41ba-b6e9-57eff5ce66a9 */
//   public void setCustomer(Object newCustomer) {
//      customer = newCustomer;
//   }
//
//   /** @pdOid 4b765ad4-de5c-4ade-bf62-a3aeb345a19d */
//   public Double total() {
//      // TODO: implement
//      return null;
//   }
//
//
//   /** @pdGenerated default getter */
//   public Collection<Customer> getMengorder() {
//      if (Mengorder == null)
//         Mengorder = new HashSet<Customer>();
//      return Mengorder;
//   }
//
//   /** @pdGenerated default iterator getter */
//   public Iterator getIteratorMengorder() {
//      if (Mengorder == null)
//         Mengorder = new HashSet<Customer>();
//      return Mengorder.iterator();
//   }
//
//   /** @pdGenerated default setter
//     * @param newMengorder */
//   public void setMengorder(Collection<Customer> newMengorder) {
//      removeAllMengorder();
//      for (Iterator iter = newMengorder.iterator(); iter.hasNext();)
//         addMengorder((Customer)iter.next());
//   }
//
//   /** @pdGenerated default add
//     * @param newCustomer */
//   public void addMengorder(Customer newCustomer) {
//      if (newCustomer == null)
//         return;
//      if (this.Mengorder == null)
//         this.Mengorder = new HashSet<Customer>();
//      if (!this.Mengorder.contains(newCustomer))
//         this.Mengorder.add(newCustomer);
//   }
//
//   /** @pdGenerated default remove
//     * @param oldCustomer */
//   public void removeMengorder(Customer oldCustomer) {
//      if (oldCustomer == null)
//         return;
//      if (this.Mengorder != null)
//         if (this.Mengorder.contains(oldCustomer))
//            this.Mengorder.remove(oldCustomer);
//   }
//
//   /** @pdGenerated default removeAll */
//   public void removeAllMengorder() {
//      if (Mengorder != null)
//         Mengorder.clear();
//   }
//   /** @pdGenerated default getter */
//
//
//   /** @pdGenerated default iterator getter */
//   public Iterator getIteratorDi Order() {
//      if (Di Order == null)
//         Di Order = new HashSet<Product>();
//      return Di Order.iterator();
//   }
//
//   /** @pdGenerated default setter
//     * @param newDi Order */
//   public void setDi Order(Collection<Product> newDi Order) {
//      removeAllDi Order();
//      for (Iterator iter = newDi Order.iterator(); iter.hasNext();)
//         addDi Order((Product)iter.next());
//   }
//
//   /** @pdGenerated default add
//     * @param newProduct */
//   public void addDi Order(Product newProduct) {
//      if (newProduct == null)
//         return;
//      if (this.Di Order == null)
//         this.Di Order = new HashSet<Product>();
//      if (!this.Di Order.contains(newProduct))
//         this.Di Order.add(newProduct);
//   }
//
//   /** @pdGenerated default remove
//     * @param oldProduct */
//   public void removeDi Order(Product oldProduct) {
//      if (oldProduct == null)
//         return;
//      if (this.Di Order != null)
//         if (this.Di Order.contains(oldProduct))
//            this.Di Order.remove(oldProduct);
//   }
//
//   /** @pdGenerated default removeAll */
//   public void removeAllDi Order() {
//      if (Di Order != null)
//         Di Order.clear();
//   }
//
//}