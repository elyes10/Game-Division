/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    private Button cart;
    @FXML
    private Button ord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void showcartwindow(ActionEvent event) {
    }

    @FXML
    private void showorderswindow(ActionEvent event) {
    }
    
}
