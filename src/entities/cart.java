/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author HP OMEN
 */
public class cart {

    private int cart_id;
    private products product;
    private int quantity;
    private int user_id;

    public cart() {
    }
     
    public cart(int cart_id, products product, int quantity, int user_id) {
        this.cart_id = cart_id;
        this.product= product;
        this.quantity = quantity;
        this.user_id = user_id;
    }

    /**
     * @return the cart_id
     */
    public int getCart_id() {
        return cart_id;
    }

    /**
     * @param cart_id the cart_id to set
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * @return the product_id
     */
    public products getProduct() {
        return product;
    }

    /**
     * @param product the products to set
     */
    public void setProduct(products product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "cart_id: " + " "+this.cart_id + " " + "product: "+ " " + this.product+ " " + "quantite: " + " " + this.quantity + " "+ "user_id: " + " "+ this.user_id + '\n';
    }
}
