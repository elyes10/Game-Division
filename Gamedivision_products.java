/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class Gamedivision_products extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       //Parent root1 = FXMLLoader.load(getClass().getResource("home1.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("UserWindow.fxml"));
         Parent root0 = FXMLLoader.load(getClass().getResource("login.fxml"));
         Parent root2 = FXMLLoader.load(getClass().getResource("adminsmenu.fxml"));
        Scene scene = new Scene(root0);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
