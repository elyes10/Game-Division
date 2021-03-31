/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.services_cart;
import Services.services_history_orders;
import Services.services_orders;
import entities.orders;
import entities.products;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author HP OMEN
 */
public class Orders_adminController implements Initializable {

    @FXML
    private VBox y;
    @FXML
    private ImageView img;
    
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TableView<orders> tableview;
    @FXML
    private TableColumn<orders, String>c1;
    @FXML
    private TableColumn<orders, Integer> c2;
    @FXML
    private TableColumn<orders, String> c3;
    @FXML
    private TableColumn<orders, String> c4;
    @FXML
    private TableColumn<orders, Date> c5;
    @FXML
    private TableColumn<orders, Double> c6;
   
    @FXML
    private TableColumn<orders, String> c61;
    @FXML
    private TableColumn<orders, String> c62;
    @FXML
    private TextField search;
    ObservableList<orders> l = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        services_orders so =new services_orders();
       
        l=so.getInitialTableData_Orders_admin();
           c1.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        c3.setCellValueFactory(new PropertyValueFactory<>("adr_livraison"));
        c4.setCellValueFactory(new PropertyValueFactory<>("country"));
        c5.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
        c6.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        c61.setCellValueFactory(new PropertyValueFactory<>("status"));
       c62.setCellValueFactory(new PropertyValueFactory<>("liste_produit"));
       c2.setCellValueFactory(new PropertyValueFactory<>("user_id"));
       
       //multiline table cell
         Callback<TableColumn<orders,String>, TableCell<orders,String>> cellFactory7 = new Callback<TableColumn<orders,String>, TableCell<orders,String>>() {
			@Override
			public TableCell call( TableColumn param) {
				final TableCell cell = new TableCell() {
					private Text label;
					@Override
					public void updateItem(Object item, boolean empty) {
						super.updateItem(item, empty);
						if (!isEmpty()) {
							label = new Text(item.toString());
							label.setWrappingWidth(140);
							setGraphic(label);
						}
					}
				};
				return cell;
			}
		};
         //multiline end
         c1.setCellFactory(cellFactory7);
         c3.setCellFactory(cellFactory7);
         c4.setCellFactory(cellFactory7);
         
         c61.setCellFactory(cellFactory7);
         c62.setCellFactory(cellFactory7);
         
          tableview.setItems(l);
          addButtonToTableordersadmin_status(l);
          addButtonToTableordersadmin_delete(l);
          
// TODO
    }    


   
   private void addButtonToTableordersadmin_status(ObservableList<orders> l) {
       services_orders so =new services_orders();
       TableColumn<orders, Void> colBtn1 = new TableColumn("");
        Callback<TableColumn<orders,Void>, TableCell<orders,Void>> cellFactory7 = new Callback<TableColumn<orders,Void>, TableCell<orders,Void>>() {
			@Override
			public TableCell<orders, Void>  call( final TableColumn<orders, Void> param) {
				final TableCell<orders,Void> cell =new TableCell<orders,Void>(){
                                        
					private final Button btnplus = new Button();
                                        {
                        ImageView btnimg = new ImageView("statusbut.jpg");
                        btnimg.setFitWidth(43);
                        btnimg.setFitHeight(43);
                        btnplus.setGraphic(btnimg);
btnplus.setBackground(Background.EMPTY);
                        btnplus.setOnAction((ActionEvent event) -> {
                            orders data = getTableView().getItems().get(getIndex());
                             so.change_order_status(data.getOrder_id(), "Delivered");
                            refrechTableorders(l);
                        });
                    }
                                        @Override
			public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnplus);
                        }
                    }	
				};
				return cell;
			}
		};
 colBtn1.setCellFactory(cellFactory7);

        tableview.getColumns().add(colBtn1);
   }
   
   
   private void addButtonToTableordersadmin_delete(ObservableList<orders> l) {
       services_orders so =new services_orders();
       TableColumn<orders, Void> colBtn1 = new TableColumn("");
        Callback<TableColumn<orders,Void>, TableCell<orders,Void>> cellFactory7 = new Callback<TableColumn<orders,Void>, TableCell<orders,Void>>() {
			@Override
			public TableCell<orders, Void>  call( final TableColumn<orders, Void> param) {
				final TableCell<orders,Void> cell =new TableCell<orders,Void>(){
                                        
					private final Button btnplus = new Button();
                                        {
                        ImageView btnimg = new ImageView("icon-delete.png");
                        btnimg.setFitWidth(33);
                        btnimg.setFitHeight(33);
                        btnplus.setGraphic(btnimg);
btnplus.setBackground(Background.EMPTY);
                        btnplus.setOnAction((ActionEvent event) -> {
                            orders data = getTableView().getItems().get(getIndex());
                             so.delete_order(data.getOrder_id());
                            
                             
                        });
                    }
                                        @Override
			public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnplus);
                        }
                    }	
				};
				return cell;
			}
		};
 colBtn1.setCellFactory(cellFactory7);

        tableview.getColumns().add(colBtn1);
   }
   

  public void refrechTableorders(ObservableList<orders> l) {
        services_orders h= new services_orders();
     l.clear();
     tableview.setItems(l);
        l = h.getInitialTableData_Orders_admin();
       tableview.setItems(l);
      
    }
  
 
}
   


