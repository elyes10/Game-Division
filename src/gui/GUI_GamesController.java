/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Games;
import Services.ServiceGames;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author farou
 */
public class GUI_GamesController implements Initializable {
    
    private Label Id;
    @FXML
    private TextField Game_name;
    @FXML
    private TextField Game_cover;
    @FXML
    private TextField Description;
    @FXML
    private Button addbtn;
    @FXML
    private TextField Game_id;
    @FXML
    private Button deletebtn;
    @FXML
    private Button showbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private TableView  tableview;
    @FXML
    private TableColumn<Map,String> tb_id;
    @FXML
    private TableColumn<Map,String> tb_name;
    @FXML
    private TableColumn<Map,String> tb_cover;
    @FXML
    private TableColumn<Map,String> tb_desc;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Services.ServiceGames sg=new ServiceGames();
    Games g= new Games();
 
    
tb_id.setCellValueFactory(new MapValueFactory<>("Game_id"));

tb_name.setCellValueFactory(new MapValueFactory<>("Game_name"));

tb_cover.setCellValueFactory(new MapValueFactory<>("Game_cover"));

tb_desc.setCellValueFactory(new MapValueFactory<>("Description"));
ObservableList<Games> l=sg.getInitialTableData();
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();
for(int i=0;i<l.size();i++)
{
    System.out.println();
          g = new Games(l.get(i).getGame_id(), l.get(i).getGame_name(),l.get(i).getGame_cover(),l.get(i).getDescription());
Map<String, Object> item1 = new HashMap<>();
item1.put("Game_id",g.getGame_id());
item1.put("Game_name" , g.getGame_name());
item1.put("Game_cover" , g.getGame_cover());
item1.put("Description" , g.getDescription());
items.add(item1);
}
tableview.getItems().addAll(items);  

    }



    
    @FXML
    private void AddGames(ActionEvent event){
    Services.ServiceGames sp=new ServiceGames();
    Games g= new Games();

    g.setGame_name(Game_name.getText());
    g.setGame_cover(Game_cover.getText());
    g.setDescription(Description.getText());
    sp.AddGames(g);
    
    }

    @FXML
    private void DeleteGames(ActionEvent event) {
        
 
        Services.ServiceGames sg=new ServiceGames();
    Games g= new Games();
    double x =Double.parseDouble(Game_id.getText());
    g.setGame_id((int) x);
    sg.DeleteGames(g);
    }

    @FXML
    private void AfficherGames(ActionEvent event) {
        Services.ServiceGames sg=new ServiceGames();
    Games g= new Games();
 
    

tb_id.setCellValueFactory(new MapValueFactory<>("Game_id"));

tb_name.setCellValueFactory(new MapValueFactory<>("Game_name"));

tb_cover.setCellValueFactory(new MapValueFactory<>("Game_cover"));

tb_desc.setCellValueFactory(new MapValueFactory<>("Description"));


ObservableList<Games> l=sg.getInitialTableData();
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();
for(int i=0;i<l.size();i++)
{
    System.out.println();
          g = new Games(l.get(i).getGame_id(), l.get(i).getGame_name(),l.get(i).getGame_cover(),l.get(i).getDescription());
Map<String, Object> item1 = new HashMap<>();
item1.put("Game_id",g.getGame_id());
item1.put("Game_name" , g.getGame_name());
item1.put("Game_cover" , g.getGame_cover());
item1.put("Description" , g.getDescription());
items.add(item1);
}
tableview.getItems().addAll(items);  
      
}

    @FXML
    private void UpdateGames(ActionEvent event) {
        Services.ServiceGames sp=new ServiceGames();
    Games g= new Games();
    
     double x =Double.parseDouble(Game_id.getText());
    g.setGame_id((int) x);
    g.setGame_name(Game_name.getText().toString());
    g.setGame_cover(Game_cover.getText().toString());
    g.setDescription(Description.getText());
    sp.UpdateGames(g);
    }
    
}
