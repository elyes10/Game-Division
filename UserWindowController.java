/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products;

import gamedivision_products.entities.product;
import gamedivision_products.entities.user;
import gamedivision_products.services.ProductsFunctions;
import gamedivision_products.services.favouritefunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.text.Document;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class UserWindowController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private TextField t;
    @FXML
    private TextField t2;


  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ProductsFunctions pf = new ProductsFunctions();
ObservableList<product> l =pf.getInitialTableData();
ObservableList<product> l1 =FXCollections.observableArrayList();;
HBox h=new HBox();

  int x=0;
  int k=0;
       for(int i=0;i<l.size();i++)
       {
           k++;
            Label lb=new Label("");
            
            lb.setText(l.get(i).getProduct_name());
            lb.setLayoutX(20);
           // System.out.println(this.receiveData());
            lb.setLayoutY(20);
            Button b=new Button("Add To Favourites");
            b.setOnAction(e->this.selectItem(lb.getText()));
            VBox h1;
    h1 = new VBox(l.get(i).getImageView());
           h1.getChildren().add(lb);
           h1.getChildren().add(b);
           grid.add(h1, k, x);
           //grid.add(lb, k+1, x+1);
           grid.setHgap(200);
           grid.setVgap(200);
         if(i%9==0)
         { 
           x=x+1; 
           k=0;
         }
       }
   
            //Pass whatever data you want. You can have multiple method calls here
           // scene2Controller.
                 
      
        
   
    } 
    //LoginController lg=new LoginController();
    public String setLabelText(String text){
        t.setText(text);
        return text;
   }
    public String setLabelText1(String text){
        t2.setText(text);
        return text;
   }
    
   // System.out.println(lg.getT1().toString());
 private void selectItem(String n) {
        
            System.out.println(n);
            System.out.print(t.getText()+t2.getText());
            favouritefunctions f=new favouritefunctions();
            int x=f.getiduser(t.getText());
            
            ProductsFunctions p=new ProductsFunctions();
            p.searchProductId(n);
            System.out.println(x+""+p.searchProductId(n));
            f.AddproducttoFavourites(x,p.searchProductId(n));
     
    }
 }
    

