/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Services.services_cart;
import Services.services_orders;
import Services.services_history_orders;


/**
 *
 * @author HP OMEN
 */
public class GameDivision extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/gui/Shop.fxml"));
      //   Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Game Division");
        stage.setScene(scene);
        stage.show();
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
         
        int logged_user_id = 10;
        services_cart sc = new services_cart();
        services_orders so = new services_orders();
        services_history_orders ho = new services_history_orders();
        //sc.addProduitPanier(1, 3, logged_user_id);
        //sc.addProduitPanier(13, 11, 100);
        //sc.addProduitPanier(2,5, logged_user_id);
        //so.add_order(logged_user_id, "133rd Street Manhattan","spain", 10010,300);
        //sc.delete_product_from_panier(2);
        //sc.vider_panier(logged_user_id);
        //sc.update_panier_product_quantity(100,13,1);
        //so.change_order_status(301, "105", "Delivered");
        //ho.afficher_history_of_user_orders(logged_user_id);
     double a =0;  
   a=sc.total_price_calcul(logged_user_id);
   
   
    }

}
