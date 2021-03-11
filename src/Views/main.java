/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author iyadh
 */
public class main extends Application {
    
    public static Stage stage = null;
    
    
    
    @Override
    public void start(Stage stage) {
  try{  
        Parent root = FXMLLoader.load(getClass().getResource("LoginUser.FXML"));
        JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);         
        Scene scene = new Scene(decorator);

        stage.setScene(scene);  
        main.stage=stage;
      
    

        stage.initStyle(StageStyle.DECORATED);
        stage.show();   
        
        
  } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
