/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.connecttoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP OMEN
 */
public class services_cart {

    Connection c = connecttoDb.getInstance().getCnx();

    public void addProduitPanier(int product_id, int quantite, int user_id) {
        Statement st;
        try {
            st = c.createStatement();
            String rec = " INSERT INTO `cart`(`product_id`, `quantite`, `user_id`) VALUES ('" + product_id + "','" + quantite + "','" + user_id + "')";
            st.executeUpdate(rec);
            System.err.println("add successful");
        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete_product_from_panier(int product_id) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("delete from cart where product_id=? ");
            pt.setInt(1, product_id);
            pt.executeUpdate();
            System.out.println("product deleted from cart");

        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void vider_panier(int user_id) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("delete from cart where user_id=? ");
            pt.setInt(1, user_id);
            pt.executeUpdate();
            System.out.println("cart vider");

        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      public void update_panier_product_quantity(int user_id,int product_id,int quantity) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("UPDATE cart SET quantite =?  WHERE user_id =? AND product_id =? ");
            pt.setInt(1, quantity);
             pt.setInt(2, user_id);
              pt.setInt(3, product_id);
            pt.executeUpdate();
            System.out.println("quantite updated");

        } catch (SQLException ex) {
            Logger.getLogger(services_cart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
