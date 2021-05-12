/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author LENOVO
 */
public class Favourites {
     private int product_id;
    private int user_id;

    public int getProduct_id() {
        return product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Favourites(int product_id, int user_id) {
        this.product_id = product_id;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Favourites{" + "product_id=" + product_id + ", user_id=" + user_id + '}';
    }
    
}
