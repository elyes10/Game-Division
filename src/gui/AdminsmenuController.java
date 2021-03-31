/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamedivision.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AdminsmenuController implements Initializable {

    @FXML
    private Button prd;
    @FXML
    private Button usr;
    @FXML
    private Button tr;
    @FXML
    private Button gms;
    @FXML
    private Button tms;
    @FXML
    private Button nus;
    @FXML
    private Button rec;
    @FXML
    private Button ord;
    @FXML
    private Button trinter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usr.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ShowUsers.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 }); 
        
          prd.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/home1.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
        
      tms.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ShowTeams.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });    
      
       ord.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Orders_admin.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });    
      
          tr.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/GUI_Tournaments.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 }); 
          
          
          gms.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/GUI_Games.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 }); 
       
          trinter.setOnAction((ActionEvent event) -> { try {
            
            
            Parent root = FXMLLoader.load(getClass().getResource("/gui/GUI_Tournaments_inter.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
       
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 }); 
          
          
    }    

    @FXML
    private void showproductswindow(ActionEvent event) throws IOException 
    {
        Stage stage=new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("home1.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showuserswindow(ActionEvent event) {
    }

    @FXML
    private void showtournamentswindow(ActionEvent event) {
    }

    @FXML
    private void showgameswindow(ActionEvent event) {
    }

    @FXML
    private void showsteamswindow(ActionEvent event) {
    }

    @FXML
    private void shownewswindow(ActionEvent event) {
    }

    @FXML
    private void showreclamswindow(ActionEvent event) {
    }


    @FXML
    private void showorderswindow(ActionEvent event) {
    }

   

   
}
