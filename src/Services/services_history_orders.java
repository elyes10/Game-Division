/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.connecttoDb;
import entities.orders;
import entities.products;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author HP OMEN
 */

public class services_history_orders {

    private Connection c = connecttoDb.getInstance().getCnx();

    public String get_orders_list_from_orders(int user_id) {
        String l = "";
        int ordernum = 0;
        final String sql = "SELECT * FROM orders where user_id='" + user_id + "'";
        try (PreparedStatement stm = getC().prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                String orders_list = "order_id " + rs.getString("order_id") + " Date " + rs.getString("date") + " Total_price " + rs.getString("total_price") + " status " + rs.getString("status") + " Product_list " + rs.getString("liste_produit");
                 ordernum=ordernum+1;
                l = l +"\n"+ " ORDER N°" + ordernum + ": " + orders_list;

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return l;
    }

  
    public ObservableList<orders> getInitialTableData_Orders_History(int user_id) {
        String sql = "SELECT * FROM orders WHERE user_id = '" + user_id + "'";
        ObservableList<orders> data = FXCollections.observableArrayList();
        try {
            PreparedStatement s = connecttoDb.getInstance().getCnx().prepareStatement(sql);
            s.executeQuery(sql);
            ResultSet res = s.executeQuery(sql);
            while (res.next()) {
                
               orders o=new orders(res.getString(1),user_id, res.getString(3), res.getString(4), res.getInt(5), res.getString(6), res.getDouble(7), res.getString(8), res.getString(9));
                
                data.add(o);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error in Building Data"+ex);
        }
        return data;
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
