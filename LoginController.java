/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products;

import gamedivision_products.entities.user;
import gamedivision_products.services.favouritefunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LoginController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
     private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private Button login;

    public String getT1()
    {
        return this.t1.getText();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public int loginonclick(ActionEvent event) throws IOException {
        favouritefunctions f=new favouritefunctions();
        if((t1.getText().equals("admin"))&&(t2.getText().equals("admin")))
        {
            Stage stage=new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("home1.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();  
        }
        if(f.login(t1.getText(), t2.getText())!=-1)
        {
        Stage stage=new Stage();
        
        //Parent root = FXMLLoader.load(getClass().getResource("UserWindow.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        UserWindowController controller2 = loader.getController();
           controller2.setLabelText(t1.getText());
            controller2.setLabelText1(t2.getText());
        stage.setScene(scene);
        stage.show();    
        }
        return f.login(t1.getText(), t2.getText());
    
    }
    
          
    
}
