/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author iyadh
 */
public class User {
    private SimpleIntegerProperty User_id;
    private SimpleStringProperty User_name;
    private SimpleStringProperty User_lastname;
    private SimpleStringProperty User_Email;
    private SimpleIntegerProperty User_phone;
    private SimpleStringProperty password;
    private SimpleStringProperty User_photo;
    private SimpleStringProperty User_gender;

    public User() {
    }
    
    
    
    
    

        public User(int User_id, String User_name, String User_lastname, String User_Email, int User_phone, String password, String User_photo, String User_gender) {
        this.User_id = new SimpleIntegerProperty(User_id);
        this.User_name = new SimpleStringProperty(User_name);
        this.User_lastname = new SimpleStringProperty(User_lastname);
        this.User_Email = new SimpleStringProperty(User_Email);
        this.User_phone = new SimpleIntegerProperty(User_phone);
        this.password = new SimpleStringProperty(password);
        this.User_photo = new SimpleStringProperty(User_photo);
        this.User_gender = new SimpleStringProperty(User_gender);
    }

     public User(String User_name, String User_lastname, String User_Email, int User_phone, String password, String User_photo, String User_gender) {
        this.User_name = new SimpleStringProperty(User_name);
        this.User_lastname = new SimpleStringProperty(User_lastname);
        this.User_Email = new SimpleStringProperty(User_Email);
        this.User_phone = new SimpleIntegerProperty(User_phone);
        this.password = new SimpleStringProperty(password);
        this.User_photo = new SimpleStringProperty(User_photo);
        this.User_gender = new SimpleStringProperty(User_gender);
    }
     
        public User(String User_name, String User_lastname, String User_Email, int User_phone,  String User_photo) {
        this.User_name = new SimpleStringProperty(User_name);
        this.User_lastname = new SimpleStringProperty(User_lastname);
        this.User_Email = new SimpleStringProperty(User_Email);
        this.User_phone = new SimpleIntegerProperty(User_phone);
        this.User_photo = new SimpleStringProperty(User_photo);
    }

/*
    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public String getUser_lastname() {
        return User_lastname;
    }

    public void setUser_lastname(String User_lastname) {
        this.User_lastname = User_lastname;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String User_Email) {
        this.User_Email = User_Email;
    }

    public int getUser_phone() {
        return User_phone;
    }

    public void setUser_phone(int User_phone) {
        this.User_phone = User_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_photo() {
        return User_photo;
    }

    public void setUser_photo(String User_photo) {
        this.User_photo = User_photo;
    }

    public String getUser_gender() {
        return User_gender;
    }

    public void setUser_gender(String User_gender) {
        this.User_gender = User_gender;
    }

    @Override
    public String toString() {
        return "User{" + "User_id=" + User_id + ", User_name=" + User_name + ", User_lastname=" + User_lastname + ", User_Email=" + User_Email + ", User_phone=" + User_phone + ", password=" + password + ", User_photo=" + User_photo + ", User_gender=" + User_gender + '}';
    }
    
    */


    public int getUser_id() {
        return User_id.get();
    }

    public String getUser_name() {
        return User_name.get();
    }

    public String getUser_lastname() {
        return User_lastname.get();
    }

    public String getUser_Email() {
        return User_Email.get();
    }

    public int getUser_phone() {
        return User_phone.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getUser_photo() {
        return User_photo.get();
    }

    public String getUser_gender() {
        return User_gender.get();
    }

    /**
     * @param User_id the User_id to set
     */
    public void setUser_id(SimpleIntegerProperty User_id) {
        this.User_id = User_id;
    }

    /**
     * @param User_name the User_name to set
     */
    public void setUser_name(SimpleStringProperty User_name) {
        this.User_name = User_name;
    }

    /**
     * @param User_lastname the User_lastname to set
     */
    public void setUser_lastname(SimpleStringProperty User_lastname) {
        this.User_lastname = User_lastname;
    }

    /**
     * @param User_Email the User_Email to set
     */
    public void setUser_Email(SimpleStringProperty User_Email) {
        this.User_Email = User_Email;
    }

    /**
     * @param User_phone the User_phone to set
     */
    public void setUser_phone(SimpleIntegerProperty User_phone) {
        this.User_phone = User_phone;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

    /**
     * @param User_photo the User_photo to set
     */
    public void setUser_photo(SimpleStringProperty User_photo) {
        this.User_photo = User_photo;
    }

    /**
     * @param User_gender the User_gender to set
     */
    public void setUser_gender(SimpleStringProperty User_gender) {
        this.User_gender = User_gender;
    }

    
    
}
