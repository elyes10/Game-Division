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
import java.util.Properties;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author HP OMEN
 */
public class services_orders {

    private Connection c = connecttoDb.getInstance().getCnx();

    public void add_order(int activ_user_id,String adr_livraison, String country,int post_code, double total_price ) {
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
    { String l=""; 
       final String sql = "SELECT cart.product_id, products.product_name, cart.quantite FROM products INNER JOIN cart ON products.product_id=cart.product_id WHERE cart.user_id = '" + user_id + "'";
try (PreparedStatement stm = getC().prepareStatement(sql);
        ResultSet rs = stm.executeQuery()) {
    while (rs.next()) {
        String product_list = rs.getString("product_id");
       String product_name = rs.getString(2);
        int product_quantite=rs.getInt(3);
        
        l=l+" / Product Id : "+product_list+" Product Name: "+product_name+" Quantity: "+product_quantite;
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
    
    public void mailing_order(int activ_user_id)
    {
         final String username = "game.division10@gmail.com";
                final String password =  "gamedivision10";
                
                
                Properties props = new Properties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                
                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });
                 try {
              Statement stmp = c.createStatement();
                     String req2 = "SELECT `User_Email` from users where User_id='"+activ_user_id+"'";
        ResultSet resultat = stmp.executeQuery(req2);
         while(resultat.next()){
           String to= resultat.getString("User_Email");
           
           
            try {
                    
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("from-email@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    message.setSubject("Order Confirmed");
                    message.setText("\n"+"Hi\n"+"Your order is being prepared\n"+"Thank you for using Game Division   ");
                    Transport.send(message);
                    JOptionPane.showMessageDialog(null, "Check your email");
                } catch (MessagingException ex) {
                    JOptionPane.showMessageDialog(null, "Oops something went wrong" + "\n" + ex.getMessage());
                }
         }
           
         } catch (SQLException ex) {
           //  Logger.getLogger(Specialiste.class.getName()).log(Level.SEVERE, null, ex);
         }

         
       }

         
       }

    
    

