/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Utils.connecttoDb;
import com.mysql.cj.xdevapi.PreparableStatement;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iyadh
 */
public class servicesUser {
    Connection c = connecttoDb.getInstance().getCnx();
    
    
    public void adduser(User u ) throws SQLException{
        Statement st;
        try {
           st = c.createStatement();
           String rec = " INSERT INTO `users`(`User_id`, `User_name`, `User_lastname`, `User_Email`, `User_phone`, `User_password`, `User_photo`, `User_gender`) VALUES ('"+u.getUser_id()+"','"+u.getUser_name()+"','"+u.getUser_lastname()+"','"+u.getUser_Email()+"','"+u.getUser_phone()+"','"+u.getPassword()+"','"+u.getUser_photo()+"','"+u.getUser_gender()+"')";
           st.executeUpdate(rec);
            System.err.println("add successful");
        } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
        public void adduser1(User u ) throws SQLException{
        Statement st;
        try {
           st = c.createStatement();
           String rec = " INSERT INTO `users`(`User_name`, `User_lastname`, `User_Email`, `User_phone`, `User_password`, `User_photo`, `User_gender`) VALUES ('"+u.getUser_name()+"','"+u.getUser_lastname()+"','"+u.getUser_Email()+"','"+u.getUser_phone()+"','"+u.getPassword()+"','"+u.getUser_photo()+"','"+u.getUser_gender()+"')";
           st.executeUpdate(rec);
           System.err.println("add successful");

        } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<User> getAll() throws SQLException{
    List<User> us = new ArrayList<>();
        PreparedStatement p;
        p = c.prepareStatement("select * from users");
        ResultSet rs = p.executeQuery();
        while (rs.next()){
         User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
         us.add(u);
            
        }
               
        
    return us;
    }
      public void showUser() {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("select * from users");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("User [  id : " + rs.getInt(1) +   ",  name  " + rs.getString(2) +   ",  lastname " + rs.getString(3) +", email "  +rs.getString(4)+" phone "+rs.getInt(5)+" password "+rs.getString(6)+" photo "+ rs.getString(7)+" gender "+rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }      
            

public void updateUser(int id, User u) {
        try {
            PreparedStatement pt = c.prepareStatement("UPDATE users SET User_name=?,User_lastname=?,User_Email=?,User_phone=?,User_password=?,User_photo=?,User_gender=? where User_id = ?");

            pt.setString(1, u.getUser_name());
            pt.setString(2, u.getUser_lastname());
            pt.setString(3,u.getUser_Email());
            pt.setInt(4, u.getUser_phone());
            pt.setString(5,u.getPassword());
            pt.setString(6, u.getUser_photo());
            pt.setString(7,u.getUser_gender());
            
            pt.setInt(8, id);
            pt.executeUpdate();
            System.err.println("update successful");

        } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
    }
      

public void deleteUser(User u) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("delete from users where User_id=? ");
            pt.setInt(1, u.getUser_id());
            pt.executeUpdate();
            System.out.println("delete successful");

        } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
            
            }
