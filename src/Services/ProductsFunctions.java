/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.product;
import entities.connecttoDb;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public class ProductsFunctions implements Interface {

    @Override
    public void addproduct(product p) 
    {
      
  String sql="INSERT INTO products (product_name,Team_id,price,Category,Quantity,img)"
                + "VALUES(?,?,?,?,?,?)";
         
        try {
            PreparedStatement Ps=connecttoDb.getInstance().getCnx().prepareStatement(sql);
            Ps.setString(1, p.getProduct_name());
            Ps.setInt(2, p.getTeam_id());
            Ps.setDouble(3, p.getPrice());
            Ps.setString(4, p.getCategory());
            Ps.setInt(5, p.getQuantity());
            Ps.setString(6, p.getImg());
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteproduct(product p) {
      //  throw new UnsupportedOperationException("Not supported yet.");
      //To change body of generated methods, choose Tools | Templates.
       String sql="DELETE FROM  products WHERE product_name=?";
         
        try {
            PreparedStatement Ps=connecttoDb.getInstance().getCnx().prepareStatement(sql);
            Ps.setString(1,p.getProduct_name());
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editproduct(product p) {
            String sql="UPDATE products SET Quantity=?,price=?,team_id=?,img=? WHERE product_name=?";
         
        try {
            PreparedStatement Ps=connecttoDb.getInstance().getCnx().prepareStatement(sql);
            Ps.setInt(1,p.getQuantity());
            Ps.setDouble(2,p.getPrice());
            Ps.setInt(3,p.getTeam_id());
            Ps.setString(5, p.getProduct_name());
            Ps.setString(4, p.getImg());
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<product> displayproduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, String> countbycategories() {
          String sql="SELECT COUNT(product_id),Category from products group by Category";
         Map<Integer,String>m=new TreeMap();
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
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
    public Map<String, List<product>> classifybycategories() {
        String sql="SELECT * FROM products";
        Map<String,List<product>>m=new TreeMap();
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery("SELECT * FROM products");
            List<product>l=new ArrayList();
            while(res.next())
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res.getInt(1));
                System.out.print(" "+res.getString(2));
                System.out.print(" "+res.getString(3));
                System.out.print(" "+res.getDouble(4));
                System.out.print(" "+res.getString(5));
                System.out.print(" "+res.getInt(6));
                System.out.print("]");
           product p=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5),res.getInt(6)
                   ,res.getString(7));     
         //  p.setimg(res.getBlob(7));   
           l.add(p);
            }   
          m=l.stream().collect(Collectors.groupingBy(p->p.getCategory()));
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
      return m; 
         
    }

    @Override
    public Map<Integer, String> countbyteams() {
        String sql="SELECT count(product_id),team_name"
                  + " from products INNER join teams on teams.team_id=products.Team_id group by Team_name" ;
         Map<Integer,String>m=new TreeMap();
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
           
            while(res.next())
            { 
            //    l.add(res.next());
                m.put(res.getInt(1),res.getString(2));
                System.out.print("[");
                System.out.print(" "+res.getInt(1));
                System.out.print(" "+res.getString(2));
                System.out.print("]");
                
               // m.put(res.getInt(1),res.getString(2) );
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
        
    }

    @Override
    public Map<Integer, List<product>> classifybyteams() {
       // throw new UnsupportedOperationException("Not supported yet.");
        String sql="SELECT * FROM products";
        Map<Integer,List<product>>m=new TreeMap();
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery("SELECT * FROM products");
            List<product>l=new ArrayList();
            while(res.next())
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res.getInt(1));
                System.out.print(" "+res.getString(2));
                System.out.print(" "+res.getString(3));
                System.out.print(" "+res.getDouble(4));
                System.out.print(" "+res.getString(5));
                System.out.print(" "+res.getInt(6));
                System.out.print("]");
         
                product p=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5),res.getInt(6)
                ,res.getString(7));     
               // p.setimg(res.getBlob(7));
                InputStream in =res.getBlob(7).getBinaryStream();  
               BufferedImage image = ImageIO.read(in);
                l.add(p);
            }   
          m=l.stream().collect(Collectors.groupingBy(p->p.getTeam_id()));
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
      return m; 
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<product> sortproduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, product> peak() {
         Map<String,product>m=new TreeMap();
       String sql="select * from products where price=(select max(price) from products ) ";
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
           // s.executeQuery(sql2);
            
         //   ResultSet res=s.executeQuery("select * from product where price=(select max(price) from product");
            ResultSet res1=s.executeQuery(sql);
            //Map<String,product>m1=new TreeMap();
           
            Map<String,product>m2=new TreeMap();
            while(res1.next() )
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res1.getInt(1));
                System.out.print(" "+res1.getString(2));
                System.out.print(" "+res1.getInt(3));
                System.out.print(" "+res1.getDouble(4));
                System.out.print(" "+res1.getString(5));
                System.out.print(" "+res1.getInt(6));
                System.out.print("]");
                product p=new product(res1.getString(2),res1.getDouble(4),res1.getInt(3),res1.getString(5),res1.getInt(6)
                ,res1.getString(7));
              //  p.setimg(res1.getBlob(7));
                m.put("most expensive products", p); 
                //product p1=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5),res.getInt(6));
         //   m.put("most expensive product", p1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return m;
    }

    @Override
    public Map<String, product> minimum() {
      //  throw new UnsupportedOperationException("Not supported yet.");
      //To change body of generated methods, choose Tools | Templates.
        Map<String,product>m=new TreeMap();
       String sql="select * from products where price=(select min(price) from products ) ";
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
           // s.executeQuery(sql2);
            
         //   ResultSet res=s.executeQuery("select * from product where price=(select max(price) from product");
            ResultSet res1=s.executeQuery(sql);
            //Map<String,product>m1=new TreeMap();
           
            Map<String,product>m2=new TreeMap();
            while(res1.next() )
            { 
            //    l.add(res.next());
                System.out.print("[");
                System.out.print(" "+res1.getInt(1));
                System.out.print(" "+res1.getString(2));
                System.out.print(" "+res1.getInt(3));
                System.out.print(" "+res1.getDouble(4));
                System.out.print(" "+res1.getString(5));
                System.out.print(" "+res1.getInt(6));
                System.out.print("]");
                product p=new product(res1.getString(2),res1.getDouble(4),res1.getInt(3),res1.getString(5),res1.getInt(6)
                ,res1.getString(7));
              //  p.setimg(res1.getBlob(7));
                m.put("most expensive products", p); 
                //product p1=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5),res.getInt(6));
         //   m.put("most expensive product", p1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return m;
    }

    @Override
    public ObservableList<product> getInitialTableData() {
       // throw new UnsupportedOperationException("Not supported yet.");
       //To change body of generated methods, choose Tools | Templates.
           String sql="SELECT product_id"
                   + ",product_name,Team_id,price,Category,Quantity,img FROM products";      
           ObservableList<product> data = FXCollections.observableArrayList();     
        try {
            PreparedStatement s = connecttoDb.getInstance().getCnx().prepareStatement(sql);
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
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
              System.out.println("Error in Building Data");             
          }
           return data;
    }
    public int searchProductId(String n)
    {
       String sql="SELECT * FROM products WHERE product_name =?";
                    List<product>l=new ArrayList();

        try {
            PreparedStatement ps = connecttoDb.getInstance().getCnx().prepareStatement(sql);
            ps.setString(1,n);
            System.out.println("currently searching for product");
            ResultSet res=ps.executeQuery();
            while(res.next())
            { 
               product pr=new product(res.getString(2),res.getDouble(4),res.getInt(3),res.getString(5)
                       ,res.getInt(6),res.getString(7));
               pr.setProduct_id(res.getInt(1));
               l.add(pr);
                System.out.println(l.toString());
            }
            System.out.println(l.toString());
             
        } catch (SQLException ex) 
        {
            Logger.getLogger(ProductsFunctions.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
      if(l.size()>0)
          return l.get(0).getProduct_id();
         else
          return -1;
 }
    
}
