/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.ProductsFunctions;
import Services.favouritefunctions;
import Services.services_cart;
import entities.products;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import gui.CartController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import gamedivision.FXMLDocumentController;
import static gui.CartController.cartlist;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP OMEN
 */
public class ShopController implements Initializable {

    @FXML
    private Button menu_button;
    @FXML
    private Button cbut;
    @FXML
    private Button exbut;
    @FXML
    private AnchorPane mainpane;
    @FXML
    private AnchorPane pane_slide;
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
    private VBox vb;

    @FXML
    private GridPane grid;
    
    services_cart sc = new services_cart();
    ObservableList<products> l = FXCollections.observableArrayList();
    int activ_user_id = gui.LoginUserController.session_user_id;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private Button favpagebut;
      TextField search=new TextField("product name");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbut.setOnAction((ActionEvent event) -> { try {
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Cart.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
        
        
         favpagebut.setOnAction((ActionEvent event) -> { try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("/gui/Favsmenu.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
         
         gbut.setOnAction((ActionEvent event) -> { try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("/gui/GUI_Front_Games.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
        
            tbut.setOnAction((ActionEvent event) -> { try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("/gui/GUI_Front_Tournaments.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 }); 
         
       scrollpane.setFitToWidth(true);
       scrollpane.setFitToHeight(true);
       grid.setStyle("-fx-background-image: url('bg.png');");
       
        ImageView btnimg = new ImageView("ex.png");
        btnimg.setFitWidth(25);
        btnimg.setFitHeight(25);
        exbut.setGraphic(btnimg);
        exbut.setOnAction((ActionEvent event) -> {
            System.exit(0);

        });

        ImageView btnimg1 = new ImageView("bars1.png");
        btnimg1.setFitWidth(25);
        btnimg1.setFitHeight(25);
        menu_button.setGraphic(btnimg1);

        l=sc.getInitialTableData();
        
        
       

        
       int x=2;
  int k=0;
      for(int i=0;i<l.size();i++)
       {
           
            Label lb=new Label("");
            
            lb.setText(l.get(i).getProduct_name());
            lb.setLayoutX(20);
            lb.setFont(new Font("Arial", 25));
            lb.setLayoutY(50);
            lb.setTextFill(Color.web("#E03A3A"));
            
         
            
            Button btnn=new Button(l.get(i).getPrice()+"$");
              {
                        ImageView btnimg3 = new ImageView("add-to-cart1.png");
                       
                        btnimg3.setFitWidth(30);
                        btnimg3.setFitHeight(30);
                        btnn.setGraphic(btnimg3);
                       int idd = l.get(i).getProduct_id();
                       btnn.setFont(new Font("Arial", 18));
                       btnn.setBackground(Background.EMPTY);
                       btnn.setTextFill(Color.web("#FFFFFF"));
                       btnn.setOnMouseEntered((MouseEvent me) -> {
                           btnn.setCursor(Cursor.HAND);
                        });
                        btnn.setOnAction((ActionEvent event) -> {
                          
                     
                           
                            sc.addProduitPanier(idd, 1, activ_user_id);
                            
                           
                        });
                    }
              
              Button favButton=new Button("");
              {
                        ImageView btnimg4 = new ImageView("fav.png");
                        btnimg4.setFitWidth(40);
                        btnimg4.setFitHeight(40);
                        favButton.setGraphic(btnimg4);
                        favButton.setBackground(Background.EMPTY);
                        
                        favButton.setOnMouseEntered((MouseEvent me) -> {
                           favButton.setCursor(Cursor.HAND);
                        });
                        
                       favButton.setOnAction(e->this.selectItem(lb.getText()));
                    }
              
            
            VBox h1;
            
    h1 = new VBox();
h1.setSpacing(15);

    h1.getChildren().add(l.get(i).getImagev());
    h1.setAlignment(Pos.CENTER);
           h1.getChildren().add(lb);
           h1.getChildren().add(btnn);
            h1.getChildren().add(favButton);
           grid.add(h1, k, x); 
          
          
           
           //grid.add(lb, k+1, x+1);  
           grid.setHgap(60);
           grid.setVgap(220);
           k++;
         if(k>3)
         { 
           x=x+1; 
           k=0;
         }
       }
        
    }
    
     private void selectItem(String n) {
        int x=activ_user_id;
            System.out.println(n);
           // System.out.print(t.getText()+t2.getText());
            favouritefunctions f=new favouritefunctions();
           // int x=f.getiduser(t.getText());
            
            ProductsFunctions p=new ProductsFunctions();
            p.searchProductId(n);
            System.out.println(x+"    "+p.searchProductId(n));
            if(f.SearchingFavourites(x,p.searchProductId(n))==-1)
            {f.AddproducttoFavourites(x,p.searchProductId(n));
           
            }
   
     
    }
     
     
   

}
