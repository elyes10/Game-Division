/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Services.servicesTeam;
import entities.Teams;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author iyadh
 */
public class AddTeamController implements Initializable {

    @FXML
    private TextField Tname;
    @FXML
    private TextField Twebsite;
    @FXML
    private TextField one;
    @FXML
    private TextField tow;
    @FXML
    private TextField three;
    @FXML
    private TextField four;
    @FXML
    private TextField five;
    @FXML
    private Button logo;
    @FXML
    private AnchorPane image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 

    @FXML
    private void ok(ActionEvent event) throws SQLException {
        
        String Tnamet = Tname.getText();
        String Twebsitet = Twebsite.getText();  
        String pic = logo.getText();
         String inputone = one.getText();
         String inputtow = tow.getText();
          String inputthree = three.getText();
           String inputfour = four.getText();
            String inputfive = five.getText();
            int onet = Integer.parseInt(inputone);
            int towt = Integer.parseInt(inputtow);
            int threet = Integer.parseInt(inputthree);
            int fourt = Integer.parseInt(inputfour);
            int fivet = Integer.parseInt(inputfive);
            
            
            
            servicesTeam st = new servicesTeam();
            Teams t = new Teams(Tnamet, pic, Twebsitet, onet, towt, threet, fourt, fivet);
            st.addteam1(t);
        
        
        
        
    }
    
    
    
       @FXML
    private void upload(ActionEvent event) {
        
         FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            logo.setText(f.toString());
        }
        
    }
}
