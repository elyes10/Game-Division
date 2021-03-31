/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Games;
import entities.Tournaments;
import entities.Tournaments_intr;
import Services.ServicesTournaments;
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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class GUI_TournamentsController implements Initializable {

  @FXML
    private TextField Tr_id;
    @FXML
    private TextField tr_cover;
    @FXML
    private TextField Game_id;
    @FXML
    private TextField team1_id;
    @FXML
    private TextField team2_id;
    @FXML
    private TextField team3_id;
    @FXML
    private TextField team4_id;
    @FXML
    private Button Addbtn;
    @FXML
    private Button delBtn;
    @FXML
    private TableColumn<Tournaments,Integer> tb_tr_id;
    @FXML
    private TableColumn<Tournaments,ImageView> tb_tr_Cover;
    @FXML
    private TableColumn<Tournaments,Integer> tb_game_id;
    @FXML
    private TableColumn<Tournaments,Integer> tb_team1_id;
    @FXML
    private TableColumn<Tournaments,Integer> tb_team2_id;
    @FXML
    private TableColumn<Tournaments,Integer> tb_team3_id;
    @FXML
    private TableColumn<Tournaments,Integer> tb_team4_id;
    @FXML
    private TableView tableview;
    
    ObservableList<Tournaments> trlist = FXCollections.observableArrayList();        
    @FXML
    private VBox y;
    @FXML
    private Button deletebtn;
    @FXML
    private Button updatebtn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
         Services.ServicesTournaments sp=new ServicesTournaments();
        Tournaments ts= new Tournaments();

                 trlist=sp.getInitialTableData();
                 tableview.setItems(trlist);
                 
                 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
                 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
                 tb_tr_Cover.setCellValueFactory(new PropertyValueFactory<>("imageView"));
                 tb_game_id.setCellValueFactory(new PropertyValueFactory<>("Game_id"));
                 tb_team1_id.setCellValueFactory(new PropertyValueFactory<>("team1_id"));
                 tb_team2_id.setCellValueFactory(new PropertyValueFactory<>("team2_id"));
                 tb_team3_id.setCellValueFactory(new PropertyValueFactory<>("team3_id"));
                 tb_team4_id.setCellValueFactory(new PropertyValueFactory<>("team4_id"));
            
        
    }   
    @FXML
    private void refresh(ActionEvent event)
    {
       Services.ServicesTournaments sp=new ServicesTournaments();
        Tournaments ts= new Tournaments();
        
      
                 
                 
                 trlist=sp.getInitialTableData();
                 tableview.setItems(trlist);
                 
                 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
                 tb_tr_id.setCellValueFactory(new PropertyValueFactory<>("tr_id"));
                 tb_tr_Cover.setCellValueFactory(new PropertyValueFactory<>("imageView"));
                 tb_game_id.setCellValueFactory(new PropertyValueFactory<>("Game_id"));
                 tb_team1_id.setCellValueFactory(new PropertyValueFactory<>("team1_id"));
                 tb_team2_id.setCellValueFactory(new PropertyValueFactory<>("team2_id"));
                 tb_team3_id.setCellValueFactory(new PropertyValueFactory<>("team3_id"));
                 tb_team4_id.setCellValueFactory(new PropertyValueFactory<>("team4_id"));
            
    }

    @FXML
    private void AddTournaments(ActionEvent event) {
         Services.ServicesTournaments sp=new ServicesTournaments();
        Tournaments ts= new Tournaments();
        
        
        double tr=Double.parseDouble(Tr_id.getText());
        double tg= Double.parseDouble(Game_id.getText());
        double t1= Double.parseDouble(team1_id.getText());
        double t2= Double.parseDouble(team2_id.getText());
        double t3= Double.parseDouble(team3_id.getText());
        double t4= Double.parseDouble(team4_id.getText());
        ts.setTr_id((int) tr);
        ts.setTr_cover(tr_cover.getText());
        ts.setGame_id((int)tg);
        ts.setTeam1_id((int) t1);
        ts.setTeam2_id((int) t2);
        ts.setTeam3_id((int) t3);
        ts.setTeam4_id((int) t4);
        
        sp.AddTournaments(ts);
              
        
    }     
/*
    @FXML
    private void AfficherTournaments(ActionEvent event) {
        
        Services.ServicesTournaments st = new ServicesTournaments();
        Tournaments t = new Tournaments();
 

tb_tr_id.setCellValueFactory(new MapValueFactory<>("Tr_id"));
tb_tr_Cover.setCellValueFactory(new MapValueFactory<>("Game_cover"));
tb_game_id.setCellValueFactory(new MapValueFactory<>("Game_id"));
tb_team1_id.setCellValueFactory(new MapValueFactory<>("team1_id"));
tb_team2_id.setCellValueFactory(new MapValueFactory<>("team2_id"));
tb_team3_id.setCellValueFactory(new MapValueFactory<>("team3_id"));
tb_team4_id.setCellValueFactory(new MapValueFactory<>("team4_id"));



ObservableList<Tournaments> l=st.getInitialTableData();
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();
for(int i=0;i<l.size();i++)
{
    Games g = new Games ();
    g.setGames(
    System.out.println();
          t = new Tournaments(l.get(i).getTr_id(), l.get(i).getTr_cover(), l.get(i).getGames(g),l.get(i).getTeam1_id(),l.get(i).getTeam2_id(), l.get(i).getTeam3_id(), l.get(i).getTeam4_id());
Map<String, Object> item1 = new HashMap<>();
item1.put("Tr_id",t.getTr_id());
item1.put("Game_cover" , t.getTr_cover());
item1.put("Game_id" , t.getGames().getGame_id());
item1.put("team1_id" , t.getTeam1_id());
item1.put("team2_id" , t.getTeam2_id());
item1.put("team3_id" , t.getTeam3_id());
item1.put("team4_id" , t.getTeam4_id());

items.add(item1);
}

tableview.getItems().addAll(items);  
    
    }
*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @FXML
    private void DeleteTournaments(ActionEvent event) {
           
         Services.ServicesTournaments st=new ServicesTournaments();
        Tournaments ts= new Tournaments();
         double tr=Double.parseDouble(Tr_id.getText());
         ts.setTr_id((int) tr);
         st.DeleteTournaments(ts);
    
    }

  @FXML
    private void UpdateTournaments(ActionEvent event) {
         Services.ServicesTournaments st = new ServicesTournaments();
        Tournaments t = new Tournaments();
        double x = Double.parseDouble(Tr_id.getText());
        double x1 = Double.parseDouble(Game_id.getText());
        double x2 = Double.parseDouble(team1_id.getText());
        double x3 = Double.parseDouble(team2_id.getText());
        double x4 = Double.parseDouble(team3_id.getText());
        double x5 = Double.parseDouble(team4_id.getText());
        
        
        t.setTr_id((int)x);
        t.setTr_cover(tr_cover.getText());
        t.getGames().setGame_id((int) x1);
        t.setTeam1_id((int)x2);
        t.setTeam2_id((int)x3);
        t.setTeam3_id((int)x4);
        t.setTeam4_id((int)x5);


        
        st.UpdateTournaments(t);
    }

   public void countbygame(){
   
   
   
     Stage stage=new Stage();
       ServicesTournaments st=new  ServicesTournaments();
        Map<Integer,String>m=st.countbyteams();
        System.out.println(m.keySet().toString()+m.values());
         CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList((m.values())));
      xAxis.setLabel("category"); 
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("score");
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Comparison between Games");
      XYChart.Series<String,Number> series = new XYChart.Series<>();
      series.setName("Most playble game"); 
     for (Map.Entry<Integer,String> entry : m.entrySet()) 
     {
       System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        series.getData().add(new XYChart.Data<>(entry.getValue(),entry.getKey()));
     }
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      barChart.getData().addAll(series);
      Group root = new Group(barChart);
      Scene scene = new Scene(root, 600, 400);

      stage.setTitle("Bar Chart");
     
      stage.setScene(scene);
      
      stage.show();        
   
   
   }
    
   
   
   
   
   
 
}

