/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.servicesTeam;
import entities.Teams;
import gamedivision.FXMLDocumentController;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author iyadh
 */
public class ShowTeamsController implements Initializable {

    @FXML
    private AnchorPane image;
    @FXML
    private TableColumn<Teams, String> colname;
    @FXML
    private TableColumn<Teams, String> collogo;
    @FXML
     private TableColumn<Teams, String> colweb;
    @FXML
    private TableColumn<Teams, Integer> col1;
    @FXML
    private TableColumn<Teams, Integer> col2;
    @FXML
    private TableColumn<Teams, Integer> col3;
    @FXML
    private TableColumn<Teams, Integer> col4;
    @FXML
    private TableColumn<Teams, Integer> col5;

    /**
     * Initializes the controller class.
     */
    
    
    
    
     ObservableList<Teams> data = FXCollections.observableArrayList();
    servicesTeam st= new servicesTeam();
    @FXML
    private TableView<Teams> table;
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
    private TextField id;
    @FXML
    private Button update;
    @FXML
    private Button deletebtn;
    @FXML
    private Button addteambut;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            data.addAll(st.getAll());
           
            colname.setCellValueFactory(new PropertyValueFactory<>("team_name"));
            collogo.setCellValueFactory(new PropertyValueFactory<>("Team_logo"));
            colweb.setCellValueFactory(new PropertyValueFactory<>("Team_Website"));
            col1.setCellValueFactory(new PropertyValueFactory<>("user1_id"));
            col2.setCellValueFactory(new PropertyValueFactory<>("user2_id"));
            col3.setCellValueFactory(new PropertyValueFactory<>("user3_id"));
            col4.setCellValueFactory(new PropertyValueFactory<>("user4_id"));
            col5.setCellValueFactory(new PropertyValueFactory<>("user5_id"));
            
            table.setItems(data);
            
          addteambut.setOnAction((ActionEvent event) -> { try {
            
             Parent root = FXMLLoader.load(getClass().getResource("/gui/AddTeam.fxml"));
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
    private void deletbtn(ActionEvent event) {
         ObservableList<Teams> selectedRows, allPeople;
        allPeople = table.getItems();
        selectedRows = table.getSelectionModel().getSelectedItems();
       Teams u = table.getSelectionModel().getSelectedItem();
       servicesTeam su = new servicesTeam();
       su.deleteTeams(u);
       
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
            logo.setText(f.toString());
            
        }    
    
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
            
            String idt = id.getText();
            int idteam = Integer.parseInt(idt);
            servicesTeam st = new servicesTeam();
            Teams t = new Teams(Tnamet, pic, Twebsitet, onet, towt, threet, fourt, fivet);
            st.updateTeams(idteam, t);
        
        
        
        
    }
    
    
    
    
}
