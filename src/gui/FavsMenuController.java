/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.product;
import Services.FavouritesFunctions;
import Services.ProductsFunctions;
import Services.favouritefunctions;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FavsMenuController implements Initializable {

    @FXML
    private AnchorPane mainpane;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private GridPane grid;
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
    private Button cbut1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
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

         //scrollpane.setFitToWidth(true);
       //scrollpane.setFitToHeight(true);
       
        
        
        grid.setStyle("-fx-background-image: url('favbg.png');");
         ProductsFunctions pf = new ProductsFunctions();
         FavouritesFunctions f=new favouritefunctions();
   ObservableList<product> l =f.getInitialTableData(3);
  // ObservableList<product> l1 =FXCollections.observableArrayList();;
   HBox h=new HBox();
       // System.out.println("t"+t.getText());



  int x=1;
  int k=0;
       for(int i=0;i<l.size();i++)
       {
           
           Button btnn=new Button(l.get(i).getPrice()+"$");
              {
                        ImageView btnimg3;
         /*  btnimg3 = new ImageView(getClass().getResource("add-to-cart1.png").toExternalForm());
                        //ImageView btnimg3 = new ImageView("");
                        btnimg3.setFitWidth(30);
                        btnimg3.setFitHeight(30);
                        btnn.setGraphic(btnimg3);*/
                       int idd = l.get(i).getProduct_id();
                       btnn.setFont(new Font("Arial", 18));
                       btnn.setBackground(Background.EMPTY);
                       btnn.setTextFill(Color.web("#FFFFFF"));
                       btnn.setOnMouseEntered((MouseEvent me) -> {
                           btnn.setCursor(Cursor.HAND);
                        });
                        btnn.setOnAction((ActionEvent event) -> {
                          
                     
                           
                         //   sc.addProduitPanier(idd, 1, activ_user_id);
                            //refrechTableCart(activ_user_id);
                          //  Double t=0.0;
                           // refrech_tot_price(t, activ_user_id);
                        });
                    }
            Label lb=new Label("");
            //lb.setText(l.get(i).getProduct_name());
            lb.setText(l.get(i).getProduct_name());
            lb.setLayoutX(20);
            lb.setFont(new Font("Arial", 25));
            lb.setLayoutY(50);
            lb.setTextFill(Color.web("#E03A3A"));
            lb.setLayoutX(20);
           // System.out.println(this.receiveData());
            lb.setLayoutY(20);
             Button delButton=new Button("");
             delButton.setOnAction(e->this.delete(lb.getText()));
             
            VBox h1;
          ImageView img =new ImageView();
          img=l.get(i).getImageView();
          img.setFitWidth(200);
          img.setFitHeight(200);
    h1 = new VBox(img);
    ImageView delbutimg= new ImageView("icon-delete.png");
                       delbutimg.setFitWidth(30);
                        delbutimg.setFitHeight(30);
                        delButton.setGraphic(delbutimg);
                        delButton.setBackground(Background.EMPTY);
                         delButton.setOnMouseEntered((MouseEvent me) -> {
                           delButton.setCursor(Cursor.HAND);
                        });
           h1.getChildren().add(lb);
           h1.getChildren().add(delButton);
             h1.setSpacing(15);
    
           //h1.getChildren().add(btnn);
           grid.add(h1, k, x);
           grid.setHgap(60);
           grid.setVgap(380);
           k++;
         if(k>3)
         { 
           x=x+1; 
           k=0;
         }
       }
        // TODO
    }    

    private void delete(String n) {
        
         favouritefunctions f=new favouritefunctions();
        ProductsFunctions pf=new  ProductsFunctions();
        
      int x=3;
      int j=pf.searchProductId(n);
        f.DeleteproductfromFavourites(j,x);
       refresh();
    }

    private void refresh() {
      grid.getChildren().clear();
       grid.setStyle("-fx-background-image: url('favbg.png');");
         ProductsFunctions pf = new ProductsFunctions();
         FavouritesFunctions f=new favouritefunctions();
   ObservableList<product> l =f.getInitialTableData(3);
  // ObservableList<product> l1 =FXCollections.observableArrayList();;
   HBox h=new HBox();
       // System.out.println("t"+t.getText());



  int x=1;
  int k=0;
       for(int i=0;i<l.size();i++)
       {
           
           Button btnn=new Button(l.get(i).getPrice()+"$");
              {
                        ImageView btnimg3;
         /*  btnimg3 = new ImageView(getClass().getResource("add-to-cart1.png").toExternalForm());
                        //ImageView btnimg3 = new ImageView("");
                        btnimg3.setFitWidth(30);
                        btnimg3.setFitHeight(30);
                        btnn.setGraphic(btnimg3);*/
                       int idd = l.get(i).getProduct_id();
                       btnn.setFont(new Font("Arial", 18));
                       btnn.setBackground(Background.EMPTY);
                       btnn.setTextFill(Color.web("#FFFFFF"));
                       btnn.setOnMouseEntered((MouseEvent me) -> {
                           btnn.setCursor(Cursor.HAND);
                        });
                        btnn.setOnAction((ActionEvent event) -> {
                          
                     
                           
                         //   sc.addProduitPanier(idd, 1, activ_user_id);
                            //refrechTableCart(activ_user_id);
                          //  Double t=0.0;
                           // refrech_tot_price(t, activ_user_id);
                        });
                    }
            Label lb=new Label("");
            //lb.setText(l.get(i).getProduct_name());
            lb.setText(l.get(i).getProduct_name());
            lb.setLayoutX(20);
            lb.setFont(new Font("Arial", 25));
            lb.setLayoutY(50);
            lb.setTextFill(Color.web("#E03A3A"));
            lb.setLayoutX(20);
           // System.out.println(this.receiveData());
            lb.setLayoutY(20);
             Button delButton=new Button("");
             delButton.setOnAction(e->this.delete(lb.getText()));
             
            VBox h1;
          ImageView img =new ImageView();
          img=l.get(i).getImageView();
          img.setFitWidth(200);
          img.setFitHeight(200);
    h1 = new VBox(img);
    ImageView delbutimg= new ImageView("icon-delete.png");
                       delbutimg.setFitWidth(30);
                        delbutimg.setFitHeight(30);
                        delButton.setGraphic(delbutimg);
                        delButton.setBackground(Background.EMPTY);
                         delButton.setOnMouseEntered((MouseEvent me) -> {
                           delButton.setCursor(Cursor.HAND);
                        });
           h1.getChildren().add(lb);
           h1.getChildren().add(delButton);
             h1.setSpacing(15);
    
           //h1.getChildren().add(btnn);
           grid.add(h1, k, x);
           grid.setHgap(60);
           grid.setVgap(380);
           k++;
         if(k>3)
         { 
           x=x+1; 
           k=0;
         }
       }    }
    
}
