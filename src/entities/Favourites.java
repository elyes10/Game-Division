/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author LENOVO
 */
public class Favourites {
    private product product_id;
    private User user_id;

    public product getProduct_id() {
        return product_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setProduct_id(product product_id) {
        this.product_id = product_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Favourites(product product_id, User user_id) {
        this.product_id = product_id;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Favourites{" + "product_id=" + product_id + ", user_id=" + user_id + '}';
    }
    
    
}
