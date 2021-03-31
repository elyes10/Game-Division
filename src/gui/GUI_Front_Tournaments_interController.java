/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import entities.Tournaments_intr;
import Services.ServicesTournaments_intr;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fares
 */
public class GUI_Front_Tournaments_interController implements Initializable {

    @FXML
    private GridPane grid;
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
   
      
         ServicesTournaments_intr tr = new ServicesTournaments_intr();
ObservableList<Tournaments_intr> l =tr.getInitialTableData();
ObservableList<Tournaments_intr> l1 =FXCollections.observableArrayList();;
HBox h=new HBox();

  int x=1;
  int k=1;
       for(int i=0;i<l.size();i++)
       {
            String link =l.get(i).getTr_link();
            ImageView img1 = new ImageView();
            img1=l.get(i).getImageView();
           
           img1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
         
     @Override
     public void handle(MouseEvent event) {
       
        Stage stage = new Stage();
        stage.setTitle("");
        StackPane root = new StackPane();
WebView webview = new WebView();
    webview.getEngine().load(link);
    webview.setPrefSize(1024, 680);
    
    stage.setScene(new Scene(webview));
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
         }
       }
   }    

  