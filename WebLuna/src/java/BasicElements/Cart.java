/*
 * Built in 2016© By Code Managers in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package BasicElements;

import java.util.ArrayList;

/**
 *
 * @author a01334390
 */
public class Cart {
    private int id_Client;
    private int id_Order;
    private ArrayList<OrderNotebooks> cart = new ArrayList<>();

    public Cart(int id_Client, int id_Order) {
        this.id_Client = id_Client;
        this.id_Order = id_Order;
    }

    public Cart(int id_Client) {
        this.id_Client = id_Client;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public ArrayList<OrderNotebooks> getCart() {
        return cart;
    }
    
    public void AddToCart(OrderNotebooks on){
        cart.add(on);
    }
    
    public void deleteFromCart(int i){
        cart.remove(i);
    }
}
