/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Games;
import entities.Tournaments_intr;
import Services.ServiceGames;
import Services.ServicesTournaments_intr;
import static java.awt.Color.white;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Fares
 */
public class GUI_Front_GamesController implements Initializable{

    @FXML
    private AnchorPane mainpane;
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
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scrollpane;
    
    private ImageView img2;
    private VBox h1 ;
    private ObservableList<Games> l;
    private MediaPlayer mediaPlayer;
     private  String url1 = "Images/video.mp4";
     MediaView media ;
  /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     

 stbut.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Shop.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
              System.out.println("ERROR" +ex);
            }
 });
          
           ImageView btnimg = new ImageView("Images/ex.png");
                        btnimg.setFitWidth(25);
                        btnimg.setFitHeight(25);
                        exbut.setGraphic(btnimg);
        exbut.setOnAction((ActionEvent event) -> {
           System.exit(0);   
        });
    
     ImageView btnimg5 = new ImageView("Images/bars1.png");
                        btnimg5.setFitWidth(25);
                        btnimg5.setFitHeight(25);
                        menu_button.setGraphic(btnimg5);
                        
                        
                        
 ServiceGames g = new ServiceGames();
ObservableList<Games> l =g.getInitialTableData();
ObservableList<Games> l1 =FXCollections.observableArrayList();;
HBox h=new HBox();

  int x=4;
  int k=0;
  scrollpane.setFitToWidth(true);
       scrollpane.setFitToHeight(true);
  grid.setStyle("-fx-background-image: url('Images/bg.png');");
       
   
    for(int i=0;i<l.size();i++)
        
       {
      
        
        String name =l.get(i).getGame_name();
        String desc =l.get(i).getDescription();
            VBox h1;
            
            ImageView img = new ImageView();
            img=l.get(i).getImageView();
            ImageView img2= l.get(i).getImageView();  
            
       
            img.setFitWidth(460);
            img.setFitHeight(270);
       
         
     img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
         
     @Override
     public void handle(MouseEvent event) {
       ((Node)(event.getSource())).getScene().getWindow().hide();
          Parent root1 = null;
         try {
             root1 = FXMLLoader.load(getClass().getResource("GUI_Front_Games.fxml"));
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
        addUIControls(gridPane,name,desc,img2);
        Scene scene = new Scene(gridPane, 1200, 650);
  
        stage.setScene(scene);
        stage.show();   

     }
});
            
         
    h1 = new VBox(l.get(i).getImageView());
        
           grid.add(h1, k, x);
           grid.setHgap(20);
           grid.setVgap(30);
           k++;
         if(k>1)
         { 
           x=x+1; 
           k=0;
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



public void addUIControls(GridPane gridPane ,String name,String desc,ImageView img2 ) {
    // Add Header
    Label headerLabel = new Label("");
    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    gridPane.add(headerLabel, 0,0,2,1);
    GridPane.setHalignment(headerLabel, HPos.LEFT);
    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
    // Add delivery Label
    
    gridPane.setStyle(("-fx-background-image: url('Images/bg.png');"));
    gridPane.add(img2, 1, 0);
    
    
    Label nameLabel = new Label("Game name : ");
    gridPane.add(nameLabel, 0,1);
    Label nameLabel1 = new Label();
    nameLabel1.setText(name);
    nameLabel.setFont(new Font("Arial", 22));
    nameLabel.setTextFill(Color.web("white"));
    nameLabel1.setFont(new Font(20));
    nameLabel1.setTextFill(Color.web("white"));
    nameLabel1.setPrefHeight(40);
    
    gridPane.add(nameLabel1, 1,1);

  
    Label emailLabel = new Label("Description : ");
    gridPane.add(emailLabel, 0, 2);
   
    
    Label descLabel = new Label();
    descLabel.setText(desc);
    emailLabel.setFont(new Font("Arial", 22));
    emailLabel.setTextFill(Color.web("white"));
    descLabel.setFont(new Font(18));
    descLabel.setTextFill(Color.web("white"));
    descLabel.setPrefWidth(1000);
        descLabel.setWrapText(true);

    
    gridPane.add(descLabel, 1, 2);
 
}
public void refresh()
{
    ServiceGames g = new ServiceGames();
ObservableList<Games> l =g.getInitialTableData();
ObservableList<Games> l1 =FXCollections.observableArrayList();;
HBox h=new HBox();

  int x=4;
  int k=0;
  scrollpane.setFitToWidth(true);
       scrollpane.setFitToHeight(true);
  grid.setStyle("-fx-background-image: url('Images/bg.png');");  
for(int i=0;i<l.size();i++)
        
       {
           
        String name =l.get(i).getGame_name();
        String desc =l.get(i).getDescription();
            VBox h1;
            
            ImageView img = new ImageView();
            img=l.get(i).getImageView();
            ImageView img2= l.get(i).getImageView(); 
            
            
            img2.setFitHeight(800);
            img2.setFitWidth(250);

            img.setFitWidth(460);
            img.setFitHeight(270);
        h1 = new VBox(l.get(i).getImageView());
        
           grid.add(h1, k, x);
           grid.setHgap(20);
           grid.setVgap(10);
           k++;
         if(k>1)
         { 
           x=x+1; 
           k=0;
         }
       }

    
}

}

