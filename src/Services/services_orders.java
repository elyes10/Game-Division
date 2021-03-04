/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.connecttoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP OMEN
 */
public class services_orders {

    private Connection c = connecttoDb.getInstance().getCnx();

    public void add_order(int activ_user_id,String adr_livraison, String country,int post_code, float total_price ) {
        Statement st;
        UUID order_id = UUID.randomUUID();
        Date date;
        date = new Date();
        String product_list ="";
        product_list=get_products_list_from_cart(activ_user_id);
        try {
            st = getC().createStatement();
            String rec = " INSERT INTO `orders`(`order_id`,`user_id`, `adr_livraison`, `country`, `post_code`, `date`, `total_price`, `liste_produit`) VALUES ('" + order_id+ "','" + activ_user_id+ "','" + adr_livraison + "','" + country + "','" + post_code+ "','" + date+ "','" + total_price+ "','"+ product_list +"')";
            st.executeUpdate(rec);
            System.err.println("add successful");
            services_cart cs=new services_cart() ;
            cs.vider_panier(activ_user_id);
        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    public String get_products_list_from_cart(int user_id) 
    { String l=""; int productnum=0;
       final String sql = "SELECT product_id FROM cart where user_id='"+ user_id +"'";
try (PreparedStatement stm = getC().prepareStatement(sql);
        ResultSet rs = stm.executeQuery()) {
    while (rs.next()) {
        String product_list = rs.getString("product_id");
        productnum=productnum+1;
        l=l+" ID N°"+productnum+ ": "+product_list;
    }
} catch (SQLException e) {
    e.printStackTrace(System.out);
} 
     return l;
    }
    
      public void change_order_status(int user_id,String order_id,String new_status) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("UPDATE orders SET status =?  WHERE user_id =? AND order_id =? ");
            pt.setString(1, new_status);
             pt.setInt(2, user_id);
              pt.setString(3, order_id);
            pt.executeUpdate();
            System.out.println("status changed to "+new_status);

        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the c
     */
    public Connection getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Connection c) {
        this.c = c;
    }
}
