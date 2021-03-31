/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import gamedivision.FXMLDocumentController;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author HP OMEN
 */
public class MenuController implements Initializable {

    @FXML
    private Button menu_button;
    @FXML
    private Button cbut;
    @FXML
    private Button exbut;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private AnchorPane pane_slide;
    @FXML
    private Button hbut;
    @FXML
    private Button gbut;
    @FXML
    private Button tbut;
    @FXML
    private Button teambut;
    @FXML
    private Button stbut;
    @FXML
    private VBox vb;
    @FXML
    private ScrollPane scrollpane;
    
    
    
   
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
          stbut.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Shop.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
          
           ImageView btnimg = new ImageView("ex.png");
                        btnimg.setFitWidth(25);
                        btnimg.setFitHeight(25);
                        exbut.setGraphic(btnimg);
        exbut.setOnAction((ActionEvent event) -> {
           System.exit(0);
          
        });
    
     ImageView btnimg1 = new ImageView("bars1.png");
                        btnimg1.setFitWidth(25);
                        btnimg1.setFitHeight(25);
                        menu_button.setGraphic(btnimg1);
   
           
    
    
    
    
    
    }    
    
    
    
}
