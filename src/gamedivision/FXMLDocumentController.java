/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision;

import Services.services_cart;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entities.product;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import Services.services_cart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP OMEN
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<product> product_table;
    @FXML
    private TableColumn<product, String> product_name;
    @FXML
    private TableColumn<product, ImageView> product_image;
    @FXML
    private TableColumn<product, Double> product_price;

    services_cart s = new services_cart();
    ObservableList<product> storelist = FXCollections.observableArrayList();

    ObservableList<product> cartlist = FXCollections.observableArrayList();
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private VBox vboxstore;
    @FXML
    private Button Clear_Cart;
    @FXML
    private Tab Store;
    @FXML
    private TableView<product> cart_table;
    @FXML
    private AnchorPane tab_cart;
    @FXML
    private TableColumn<product, String> product_name_cart;
    @FXML
    private TableColumn<product, ImageView> product_image_cart;
    @FXML
    private TableColumn<product, Integer> quantity_cart;
    @FXML
    private TableColumn<product, Double> price_cart;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        product_name.setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        product_image.setCellValueFactory(new PropertyValueFactory<>("imagev"));
        product_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        product_name_cart.setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        product_image_cart.setCellValueFactory(new PropertyValueFactory<>("imagev"));
        price_cart.setCellValueFactory(new PropertyValueFactory<>("Price"));
        services_cart sc = new services_cart();

        storelist = sc.getInitialTableData(); //get liste produit
        product_table.setItems(storelist); // table store affichage
        addButtonToTableStore();           //button addtocart
        
        cartlist =sc.getInitialTableData_Cart(10); //get liste cart of user id 10 replace with activ user
        cart_table.setItems(cartlist);
       
    }

    private void addButtonToTableStore() {
        TableColumn<product, Void> colBtn = new TableColumn("Add To Cart");
        services_cart sc = new services_cart();
        Callback<TableColumn<product, Void>, TableCell<product, Void>> cellFactory = new Callback<TableColumn<product, Void>, TableCell<product, Void>>() {
            @Override
            public TableCell<product, Void> call(final TableColumn<product, Void> param) {
                final TableCell<product, Void> cell = new TableCell<product, Void>() {

                    private final Button btn = new Button();

                    {
                        ImageView btnimg = new ImageView("addbtn.png");
                        btnimg.setFitWidth(50);
                        btnimg.setFitHeight(50);
                        btn.setGraphic(btnimg);

                        btn.setOnAction((ActionEvent event) -> {
                            product data = getTableView().getItems().get(getIndex());

                            sc.addProduitPanier(data.getProduct_id(), 1, 10);
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        product_table.getColumns().add(colBtn);

    }
}
