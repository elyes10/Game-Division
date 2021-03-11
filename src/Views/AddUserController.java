/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Services.servicesUser;
import entities.User;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author iyadh
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField phone;
    @FXML
    private TextField password;
    @FXML
    private Button photo;
    @FXML
    private TextField gender;
    @FXML
    private TextField email;
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
            String nameu = name.getText();        
            String lastnameu = lastname.getText();
            String emailu = email.getText();
            String pwd = password.getText();
            String pic = photo.getText();
            String sex = gender.getText();
            String inputphone = phone.getText();
            int phoneu = Integer.parseInt(inputphone);
            servicesUser su = new servicesUser();
            User u = new User(nameu, lastnameu, emailu, phoneu, pwd, pic , sex);
            su.adduser1(u);
           
    }
    
    @FXML
    private void upload(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(image.getScene().getWindow());
        if(f != null){
            photo.setText(f.toString());
        }
    }
}
