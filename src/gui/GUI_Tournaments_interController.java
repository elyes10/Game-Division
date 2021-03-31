/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Tournaments;
import entities.Tournaments_intr;
import Services.ServicesTournaments_intr;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class GUI_Tournaments_interController implements Initializable {
  @FXML
    private TableView tableview;
    
    @FXML
    private TextField Tr_id;
    @FXML
    private Button Addbtn;
    @FXML
    private TextField Tr_cover;
    @FXML
    private TextField Tr_link;
    @FXML
    private TableColumn<Tournaments_intr,String> tb_tr_id;
    @FXML
    private TableColumn<Tournaments_intr,ImageView> tb_tr_cover;
    @FXML
    private TableColumn<Tournaments_intr,String> tb_tr_link;
    ObservableList<Tournaments_intr> trlist = FXCollections.observableArrayList(); 
    @FXML
    private VBox y;
    @FXML
    private Button deletebtn1;
    @FXML
    private Button updatebtn1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ServicesTournaments_intr sp=new ServicesTournaments_intr();
        Tournaments_intr ts= new Tournaments_intr();
        trlist=sp.getInitialTableData();
        tableview.setItems(trlist);
        
 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
tb_tr_cover.setCellValueFactory(new PropertyValueFactory<>("imageView"));
tb_tr_link.setCellValueFactory(new PropertyValueFactory<>("tr_link"));


       
    }
    @FXML
    public void refresh(ActionEvent event){
   ServicesTournaments_intr sp=new ServicesTournaments_intr();
        Tournaments_intr ts= new Tournaments_intr();
        trlist=sp.getInitialTableData();
        tableview.setItems(trlist);
        
 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
tb_tr_cover.setCellValueFactory(new PropertyValueFactory<>("imageView"));
tb_tr_link.setCellValueFactory(new PropertyValueFactory<>("tr_link"));
    }
    @FXML
    private void DeleteTournaments_inter(ActionEvent event) {
        Services.ServicesTournaments_intr sv = new ServicesTournaments_intr();
        Tournaments_intr tr = new Tournaments_intr();
        double x = Double.parseDouble(Tr_id.getText());

        tr.setTr_id((int) x);
        sv.DeleteTournaments_inter(tr);

    }
//
//    @FXML
//    private void AfficherTournaments_inter(ActionEvent event) {
//      
//            Services.ServicesTournaments_intr sv = new ServicesTournaments_intr();
//            Tournaments_intr tr = new Tournaments_intr();
//            
// 
//tb_tr_id.setCellValueFactory(new MapValueFactory<>("Tr_id"));
//tb_tr_cover.setCellValueFactory(new MapValueFactory<>("tr_cover"));
//tb_tr_link.setCellValueFactory(new MapValueFactory<>("tr_link"));
//
//ObservableList<Tournaments_intr> l=sv.getInitialTableData();
//ObservableList<Map<String, Object>> items =
//    FXCollections.<Map<String, Object>>observableArrayList();
//for(int i=0;i<l.size();i++)
//{
//    System.out.println();
//                Tournaments_intr t = new Tournaments_intr(l.get(i).getTr_id(), l.get(i).getTr_cover(), l.get(i).getTr_link());
//Map<String, Object> item1 = new HashMap<>();
//item1.put("Tr_id",t.getTr_id());
//item1.put("tr_cover" ,t.getTr_cover());
//item1.put("tr_link" , t.getTr_link());
//
//items.add(item1);
//}
//
//tableview.getItems().addAll(items);  
//        
//    }
    
    @FXML
    private void UpdateTournaments_inter(ActionEvent event) {
        Services.ServicesTournaments_intr sv = new ServicesTournaments_intr();
        Tournaments_intr tr = new Tournaments_intr();
        
         double x =Double.parseDouble(Tr_id.getText());
        
        tr.setTr_id((int)x);
        tr.setTr_cover(Tr_cover.getText());
        tr.setTr_link(Tr_link.getText());
        sv.UpdateTournaments_inter(tr);
    }

    @FXML
    private void AddTournaments_inter(ActionEvent event) {
         Services.ServicesTournaments_intr sv = new ServicesTournaments_intr();
        Tournaments_intr tr = new Tournaments_intr();
        double x=Double.parseDouble(Tr_id.getText());
        Tournaments_intr tr1 = new Tournaments_intr((int) x,Tr_cover.getText(),Tr_link.getText());
                
                
      
        
        sv.AddTournaments_inter(tr1);
    }

   
   
}
