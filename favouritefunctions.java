/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import gamedivision_products.entities.*;
import gamedivision_products.utilities.connect2Database;
import java.util.HashMap;

/**
 *
 * @author LENOVO
 */
public class favouritefunctions implements FavouritesFunctions{

    @Override
    public void AddproducttoFavourites(int i, int j) {
          String sql="INSERT INTO favourites (user_id,Product_id)"
                + "VALUES(?,?)";
         
        try {
            PreparedStatement Ps=connect2Database.getInstance().getCnx().prepareStatement(sql);
            
            Ps.setInt(1,i);
            Ps.setInt(2,j);
            
           // Ps.setString(6, p.getimg());
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int SearchingFavourites(int i, int j)
     {
       int existing=-1;
       int x=0;
        String sql="SELECT count(Product_id) FROM favourites WHERE user_id=? and Product_id=?";
                    //List<user>l=new ArrayList();

        try {
            PreparedStatement ps = connect2Database.getInstance().getCnx().prepareStatement(sql);
            
            ps.setInt(1, i);
            ps.setInt(2, j);
            //ps.executeQuery(sql);
            System.out.println("currently searching for user");
            ResultSet res=ps.executeQuery();
           
            while(res.next())
            { 
                x=res.getInt(1);
             System.out.println(res.getInt(1));
            }
           if(x>=1)
           {
               existing=1;
           }
            
            
             
        } catch (SQLException ex) 
        {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
         return existing;
     }

    @Override
    public void DeleteproductfromFavourites(int i, int j) {
         String sql="DELETE FROM  favourites WHERE Product_id=? and user_id=?";
         
        try {
            PreparedStatement Ps=connect2Database.getInstance().getCnx().prepareStatement(sql);
            Ps.setInt(1,i);
            System.out.println("deleting...");
            Ps.setInt(2,j);
            Ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    @Override
 public  int login(String t,String y)
         
 {
     String sql="SELECT * FROM users WHERE User_Email=? and User_Password=?";
                    List<user>l=new ArrayList();

        try {
            PreparedStatement ps = connect2Database.getInstance().getCnx().prepareStatement(sql);
            
            ps.setString(1, t);
            ps.setString(2, y);
            //ps.executeQuery(sql);
            System.out.println("currently searching for user");
            ResultSet res=ps.executeQuery();
            while(res.next())
            { 
                user u=new user(res.getInt(1),res.getString(2),res.getString(3),res.getString(4)
                       ,res.getInt(5),res.getString(6),res.getString(7),res.getString(8));
               l.add(u);
               
            }
            System.out.println(l.toString());
             
        } catch (SQLException ex) 
        {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
      if(l.size()>0)
          return l.get(0).getUser_id();
         else
          return -1;
 }

    @Override
    public Map<Integer,String> countFavouriteProductsbyUser() {
       String sql= "select count(product_id),User_name from favourites "
                + "inner join users on users.User_id=favourites.user_id group by user_name";
        Map<Integer,String>m=new TreeMap();
        try {
            Statement s = connect2Database.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
            
            while(res.next())
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res.getInt(1));
                System.out.print(" "+res.getString(2));
                System.out.print("]");
                m.put(res.getInt(1),res.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public Map<String, String> classify() {
        String sql= "select product_name,User_name from favourites inner "
                + "join users on users.User_id =favourites.user_id inner join products "
                + "on favourites.Product_id=products.product_id ";
        Map<String,String>m=new TreeMap();
        try {
            Statement s = connect2Database.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
            
            while(res.next())
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res.getString(1));
                System.out.print(" "+res.getString(2));
                System.out.print("]");
                m.put(res.getString(1),res.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
        
    }

    @Override
    public int getiduser(String n) {
        
//throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
String sql="SELECT * FROM users WHERE User_Email=? ";
                    List<user>l=new ArrayList();

        try {
            PreparedStatement ps = connect2Database.getInstance().getCnx().prepareStatement(sql);
            
            ps.setString(1, n);
           
            //ps.executeQuery(sql);
            System.out.println("currently searching for user");
            ResultSet res=ps.executeQuery();
            while(res.next())
            { 
                user u=new user(res.getInt(1),res.getString(2),res.getString(3),res.getString(4)
                       ,res.getInt(5),res.getString(6),res.getString(7),res.getString(8));
               l.add(u);
               
            }
            System.out.println(l.toString());
//            System.out.println("id+"+l.get(0).getUser_id());
             
        } catch (SQLException ex) 
        {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
        
      if(l.size()>0)
          return l.get(0).getUser_id();
         else
          return -1;

    }

    @Override
    public ObservableList<product> getInitialTableData(int i) {
       String sql="select * from products "
               + "inner join favourites on favourites.product_id "
               + "=products.product_id WHERE User_id=?";    
           ObservableList<product> data = FXCollections.observableArrayList();     
           
        try {
            PreparedStatement ps = connect2Database.getInstance().getCnx().prepareStatement(sql);
           // s.executeQuery(sql);
             ps.setInt(1,i);
            ResultSet res=ps.executeQuery();
            while(res.next())
            { 
               product p=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5),res.getInt(6),res.getString(7));  
               p.setProduct_id(res.getInt(1));
                System.out.println("id="+p.getProduct_id());
               data.add(p);
            }   
            System.out.println(data);
            }
        catch(Exception ex)
          {
                Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Error in Building Data");             
          }
           return data;
    }
    public void savelogin(String x,String y)
    {
           String sql="INSERT INTO loginhistory (Email,Password)"
                + "VALUES(?,?)";
         
        try {
            PreparedStatement Ps=connect2Database.getInstance().getCnx().prepareStatement(sql);
            
            Ps.setString(1,x);
            Ps.setString(2,y);
            
           // Ps.setString(6, p.getimg());
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<String> getActiveUser()
    {
        String sql="SELECT `Email`, `password` FROM `loginhistory`"
                + " WHERE x=(select MAX(x) FROM loginhistory)";    
           List<String>l=new ArrayList();    
           
        try {
            PreparedStatement ps = connect2Database.getInstance().getCnx().prepareStatement(sql);
            ResultSet res=ps.executeQuery();
            while(res.next())
            { 
              l.add(res.getString(1));
              l.add(res.getString(2));
            }   
            System.out.println(l.toString());
            }
        catch(Exception ex)
          {
                Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Error in Building Data");             
          }  
        return l;
    }
   
    
}
