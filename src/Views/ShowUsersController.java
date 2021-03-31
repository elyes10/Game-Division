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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author iyadh
 */
public class ShowUsersController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private Button delbtn;
    @FXML
    private TableColumn<User, String> firstname;
    @FXML
    private TableColumn<User, String> lastname;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, Integer> phone;
    @FXML
    private TableColumn<User, String> photo;
    @FXML
    private TableColumn<User, String> gender;
    @FXML
    private AnchorPane image;
    @FXML
    private TextField updname;
    @FXML
    private TextField updlastname;
    @FXML
    private TextField updmail;
    @FXML
    private TextField updphone;
    @FXML
    private Button updphoto;
    @FXML
    private Button update;
    @FXML
    private TextField id;
    
    
    private Stage primaryStage;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void ok(ActionEvent event) throws SQLException {    
            String input = id.getText();
            int iid = Integer.parseInt(input);
            String nameu = updname.getText();        
            String lastnameu = updlastname.getText();
            String emailu = updmail.getText();
            String pic = updphoto.getText();
            String inputphone = updphone.getText();
            int phoneu = Integer.parseInt(inputphone);
            servicesUser su = new servicesUser();
            User u = new User(nameu, lastnameu, emailu, phoneu,  pic );
            su.updateUser1(iid, u);
             
           
    }
    
    
    @FXML
    private void deletbtn(ActionEvent event) {
         ObservableList<User> selectedRows, allPeople;
        allPeople = table.getItems();
        selectedRows = table.getSelectionModel().getSelectedItems();
       User u = table.getSelectionModel().getSelectedItem();
       servicesUser su = new servicesUser();
       su.deleteUser(u);
       
       Notifications notifictaionBuilder = Notifications.create()
                    .title("GAMEDIVISION")
                    .text("Votre Utilisateur a été supprimé avec succes")
                    .graphic(null)
                    .position(Pos.TOP_RIGHT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Clicked on notifictaion");
            });
            notifictaionBuilder.darkStyle();
            notifictaionBuilder.show();

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
    
    
 ObservableList<User> data = FXCollections.observableArrayList();
    servicesUser su= new servicesUser();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      data.addAll(su.getAll());
    firstname.setCellValueFactory(new PropertyValueFactory<>("User_name"));
    lastname.setCellValueFactory(new PropertyValueFactory<>("User_lastname"));
    email.setCellValueFactory(new PropertyValueFactory<>("User_Email"));
    phone.setCellValueFactory(new PropertyValueFactory<>("User_phone"));
    photo.setCellValueFactory(new PropertyValueFactory<>("User_photo"));
    gender.setCellValueFactory(new PropertyValueFactory<>("User_gender"));
    
    
    table.setItems(data); 
    }
@FXML
    private void printusers(ActionEvent event) {
        
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
           Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
    Node root = this.table;
           job.printPage(root);
           job.endJob();
    }
    
}    
    
    
}
