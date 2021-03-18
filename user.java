/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products.entities;

/**
 *
 * @author LENOVO
 */
public class user {
    private int User_id ;

private String User_name ;

private String User_lastname;

private String User_Email ;

private int User_phone; 

    public user(int User_id, String User_name, String User_lastname, String User_Email, int User_phone, String User_password, String User_photo, String User_gender) {
        this.User_id = User_id;
        this.User_name = User_name;
        this.User_lastname = User_lastname;
        this.User_Email = User_Email;
        this.User_phone = User_phone;
        this.User_password = User_password;
        this.User_photo = User_photo;
        this.User_gender = User_gender;
    }

private String User_password ;

private String User_photo; 

private String User_gender;

    public int getUser_id() {
        return User_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public String getUser_lastname() {
        return User_lastname;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public int getUser_phone() {
        return User_phone;
    }

    public String getUser_password() {
        return User_password;
    }

    public String getUser_photo() {
        return User_photo;
    }

    public String getUser_gender() {
        return User_gender;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public void setUser_lastname(String User_lastname) {
        this.User_lastname = User_lastname;
    }

    public void setUser_Email(String User_Email) {
        this.User_Email = User_Email;
    }

    public void setUser_phone(int User_phone) {
        this.User_phone = User_phone;
    }

    public void setUser_password(String User_password) {
        this.User_password = User_password;
    }

    public void setUser_photo(String User_photo) {
        this.User_photo = User_photo;
    }

    public void setUser_gender(String User_gender) {
        this.User_gender = User_gender;
    }

    @Override
    public String toString() {
        return "user{" + "User_id=" + User_id + ", User_name=" + User_name + ", User_lastname=" + User_lastname + ", User_Email=" + User_Email + ", User_phone=" + User_phone + ", User_password=" + User_password + ", User_photo=" + User_photo + ", User_gender=" + User_gender + '}';
    }
    
}
