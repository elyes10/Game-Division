/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Services.servicesUser;
import static Views.main.stage;
import entities.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

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
    @FXML
   
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
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
           Stage stage = new Stage();
           QRCodegen(stage);
            
           
    }
    
    @FXML
        public void QRCodegen(Stage primaryStage) {
        // GENERATE QR CODE
        ByteArrayOutputStream out = QRCode.from("LT Jerry0022").to(ImageType.PNG).withSize(200, 200).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        // SHOW QR CODE
        BorderPane root = new BorderPane();
        Image image = new Image(in);
        ImageView view = new ImageView(image);
        view.setStyle("-fx-stroke-width: 2; -fx-stroke: blue");
        root.setCenter(view);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
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
