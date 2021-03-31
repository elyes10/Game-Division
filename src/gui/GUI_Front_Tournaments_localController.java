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
import Services.ServicesTournaments_intr;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class GUI_Front_Tournaments_localController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private Button exbut;
    @FXML
    private AnchorPane pane_slide;
    @FXML
    private Button menu_button;
    @FXML
    private VBox vb;
    @FXML
    private Button hbut;
    @FXML
    private Button gbut;
    @FXML
    private Button tbut;
    @FXML
    private Button teambut;
    @FXML
    private Button stbut;
    @FXML
    private Button cbut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
          
        
        
        
           ImageView btnimg = new ImageView("Images/ex.png");
                        btnimg.setFitWidth(25);
                        btnimg.setFitHeight(25);
                        exbut.setGraphic(btnimg);
        exbut.setOnAction((ActionEvent event) -> {
           System.exit(0);   
        });
         ServicesTournaments tr = new ServicesTournaments();
ObservableList<Tournaments> l =tr.getInitialTableData();
ObservableList<Tournaments> l1 =FXCollections.observableArrayList();;
HBox h=new HBox();

  int x=1;
  int k=1;
       for(int i=0;i<l.size();i++)
       {
             try {
                 ServicesTournaments st = new ServicesTournaments();
                 
                 String gamename=st.getgamename(l.get(i).getGame_id());
                  
                 String team1= st.getteamname(l.get(i).getTeam1_id());
             
                 String team2= st.getteamname(l.get(i).getTeam2_id());
            
                 String team3= st.getteamname(l.get(i).getTeam3_id());
            
                 String team4= st.getteamname(l.get(i).getTeam4_id());
                 
                 
                 ImageView img2= l.get(i).getImageView();
                 
                 ImageView img1 = new ImageView();
                 img1=l.get(i).getImageView();
                 
                 img1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                     
                     @Override
                     public void handle(MouseEvent event) {
                         
                         ((Node)(event.getSource())).getScene().getWindow().hide();
                         Parent root1 = null;
                         try {
                             root1 = FXMLLoader.load(getClass().getResource("GUI_Front_Tournaments_local.fxml"));
                         } catch (IOException ex) {
                             Logger.getLogger(GUI_Front_GamesController.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         Scene scene1 = new Scene(root1);
                         Stage stage1 = new Stage();
                         stage1.setScene(scene1);
                         stage1.show();
                         
                         
                         Stage stage = new Stage();
                         stage.setTitle("");
                         StackPane root = new StackPane();
                         GridPane gridPane = createRegistrationFormPane();
                         img2.setFitWidth(700);
                         Scene scene = new Scene(gridPane, 1200, 650);
                         addUIControls(gridPane, team1, team2, team3, team4, img2,gamename);
                         
                         stage.setScene(scene);
                         stage.show();
                         
                     }
                 });
                 
                 
                 VBox h1;
                 ImageView img = new ImageView();
                 img=l.get(i).getImageView();
                 img.setFitWidth(1000);
                 img.setFitHeight(320);
                 
                 
                 h1 = new VBox(l.get(i).getImageView());
                 grid.add(h1, k, x);
                 grid.setHgap(10);
                 grid.setVgap(8);
                 
                 x=x+1; 
             } catch (SQLException ex) {
                 Logger.getLogger(GUI_Front_Tournaments_localController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
       }
    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints
        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }



public void addUIControls(GridPane gridPane,String team1,String team2,String team3,String team4,ImageView img2,String gamename ) {
    // Add Header
    Label headerLabel = new Label("");
    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    gridPane.add(headerLabel, 0,0,2,1);
    GridPane.setHalignment(headerLabel, HPos.LEFT);
    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
    // Add delivery Label
    
    gridPane.setStyle(("-fx-background-image: url('Images/bg.png');"));
    gridPane.add(img2, 1, 0);
    
    
    Label nameLabel = new Label("Team1 : ");
    nameLabel.setFont(new Font("Arial", 22));
    nameLabel.setTextFill(Color.web("white"));
    gridPane.add(nameLabel, 0,1);
    Label team1_lab = new Label();
    team1_lab.setText(team1);
    team1_lab.setTextFill(Color.web("white"));
    team1_lab.setFont(new Font("Arial", 22));
    gridPane.add(team1_lab, 1,1);
    
    
    Label nameLabel2 = new Label("Team2 : ");
     nameLabel2.setFont(new Font("Arial", 22));
    nameLabel2.setTextFill(Color.web("white"));
    gridPane.add(nameLabel2, 0,2);
    Label team2_lab = new Label();
    team2_lab.setText(team2);
    team2_lab.setTextFill(Color.web("white"));
    team2_lab.setFont(new Font("Arial", 22));
    gridPane.add(team2_lab, 1,2);
    
    
    Label nameLabel3 = new Label("Team3 : ");
     nameLabel3.setFont(new Font("Arial", 22));
    nameLabel3.setTextFill(Color.web("white"));
    gridPane.add(nameLabel3, 0,3);
    Label team3_lab = new Label();
    team3_lab.setText(team3);
    team3_lab.setTextFill(Color.web("white"));
    team3_lab.setFont(new Font("Arial", 22));
    gridPane.add(team3_lab, 1,3);
    
    
    
    Label nameLabel4 = new Label("Team4 : ");
     nameLabel4.setFont(new Font("Arial", 22));
    nameLabel4.setTextFill(Color.web("white"));
    gridPane.add(nameLabel4, 0,4);
    Label team4_lab = new Label();
    team4_lab.setText(team4);
    team4_lab.setTextFill(Color.web("white"));
    team4_lab.setFont(new Font("Arial", 22));
    gridPane.add(team4_lab, 1,4);
    
    Label gamelab = new Label("Game : ");
     gamelab.setFont(new Font("Arial", 22));
     gamelab.setTextFill(Color.web("white"));
    gridPane.add(gamelab, 0,5);
    Label game = new Label();
    game.setText(gamename);
    game.setTextFill(Color.web("white"));
    game.setFont(new Font("Arial", 22));
    gridPane.add(game, 1,5);

}

   }    

  