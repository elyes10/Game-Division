/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
public class GUI_Front_TournamentsController implements Initializable {

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
    private Button btn_tr_local;
    @FXML
    private Button btn_tr_inter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        
        
        
          btn_tr_local.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI_Front_Tournaments_local.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
              System.out.println("ERROR"+ ex);
            }});
        
        btn_tr_inter.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("GUI_Front_Tournaments_inter.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
              System.out.println("ERROR" +ex);
            }});
        
 
        ImageView btnimg1 = new ImageView("/Images/img5.png");
                        btnimg1.setFitWidth(1020);
                        btnimg1.setFitHeight(330);
                        btn_tr_local.setGraphic(btnimg1);
                        
        ImageView btnimg2 = new ImageView("/Images/inter.jpg");
                        btnimg2.setFitWidth(1030);
                        btnimg2.setFitHeight(380);
                        btn_tr_inter.setGraphic(btnimg2);
        
       
        
          stbut.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Shop.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
              System.out.println("ERROR" +ex);
            }
 });
          
           ImageView btnimg = new ImageView("Images/ex.png");
                        btnimg.setFitWidth(25);
                        btnimg.setFitHeight(25);
                        exbut.setGraphic(btnimg);
        exbut.setOnAction((ActionEvent event) -> {
           System.exit(0);   
        });
    
     ImageView btnimg5 = new ImageView("Images/bars1.png");
                        btnimg5.setFitWidth(25);
                        btnimg5.setFitHeight(25);
                        menu_button.setGraphic(btnimg5);
 
    }       
}
