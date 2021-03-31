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

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import gamedivision.FXMLDocumentController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author HP OMEN
 */
public class CartController implements Initializable {

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
    private AnchorPane tab_cart;
    @FXML
     private TableView<products> cart_table;
    @FXML
    private TableColumn<products, String> product_name_cart;
    @FXML
    private TableColumn<products, ImageView> product_image_cart;
    @FXML
    private TableColumn<products, Integer> quantity_cart;
    @FXML
    private TableColumn<products, Double> price_cart;
    @FXML
    private Button Clear_Cart;
    @FXML
    private Button orders_history_button;
    @FXML
    private Button checkout_butt;
    @FXML
    private Label tot_price;
    
    ObservableList<orders> orders_historylist = FXCollections.observableArrayList();
    services_history_orders ho = new services_history_orders();
    services_cart s = new services_cart();
   static ObservableList<products> cartlist = FXCollections.observableArrayList();
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int activ_user_id = gui.LoginUserController.session_user_id; 
   
   
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
Runnable task = () -> {
    cart_table.refresh();
};
executor.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

          stbut.setOnAction((ActionEvent event) -> { try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Shop.fxml"));
                 Scene scene = new Scene(root);
                 
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
 });
          
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
   
    //cart table affich
   
        product_name_cart.setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        product_image_cart.setCellValueFactory(new PropertyValueFactory<>("imagev"));
        price_cart.setCellValueFactory(new PropertyValueFactory<>("Price"));
        quantity_cart.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
       services_cart sc = new services_cart();
        Double total_price=sc.total_price_calcul(activ_user_id);
        tot_price.setText(String.valueOf(total_price));
       cartlist = sc.getInitialTableData_Cart(activ_user_id); //get liste cart of user id 10 replace with activ user
        cart_table.setItems(cartlist);
        addButtonToTableCartQuantityMinus(activ_user_id);
        addButtonToTableCartQuantity(activ_user_id);
        addButtonToTableCartDelete(activ_user_id);

        ImageView clearimg = new ImageView("empty-cart.png");
        clearimg.setFitWidth(30);
        clearimg.setFitHeight(30);
        Clear_Cart.setGraphic(clearimg);
        Clear_Cart.setOnAction((ActionEvent event) -> {
            sc.vider_panier(activ_user_id);
            refrechTableCart(activ_user_id);
            Double t=0.0;
                            refrech_tot_price(t, activ_user_id);
            Notifications notifictaionBuilder = Notifications.create()
                    .title("Cart")
                    .text("Cart cleared")
                    .graphic(null)
                    .position(Pos.TOP_RIGHT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Clicked on notifictaion");
            });
            notifictaionBuilder.darkStyle();
            notifictaionBuilder.show();
        });
        
        checkout_butt.setOnAction((ActionEvent event) -> {
           double pricet=sc.total_price_calcul(activ_user_id);
           tot_price.setText(String.valueOf(pricet));
            create_checkout_page(activ_user_id,pricet);
        });

        orders_history_button.setOnAction((ActionEvent event) -> {
            refrechTableorders(activ_user_id);
            create_ordersHistory_Table();
        });

        orders_historylist = ho.getInitialTableData_Orders_History(activ_user_id);

    ImageView checkimg=new ImageView("checkbtn.png");
    checkout_butt.setGraphic(checkimg);
    checkout_butt.setBackground(Background.EMPTY);
    checkimg.setFitWidth(316);
    checkimg.setFitHeight(40);
    }


private void addButtonToTableCartDelete(int activ_user_id) {
        TableColumn<products, Void> colBtn1 = new TableColumn("Delete From Cart");
        services_cart sc = new services_cart();
        Callback<TableColumn<products, Void>, TableCell<products, Void>> cellFactory = new Callback<TableColumn<products, Void>, TableCell<products, Void>>() {
            @Override
            public TableCell<products, Void> call(final TableColumn<products, Void> param) {
                final TableCell<products, Void> cell = new TableCell<products, Void>() {

                    private final Button btn1 = new Button();

                    {
                        ImageView btnimg = new ImageView("icon-delete.png");
                        btnimg.setFitWidth(30);
                        btnimg.setFitHeight(30);
                        btn1.setGraphic(btnimg);

                        btn1.setOnAction((ActionEvent event) -> {
                            products data = getTableView().getItems().get(getIndex());

                            sc.delete_product_from_panier(data.getProduct_id(), activ_user_id);
                            refrechTableCart(activ_user_id);
                            Double t=0.0;
                            refrech_tot_price(t, activ_user_id);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn1);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn1.setCellFactory(cellFactory);

        cart_table.getColumns().add(colBtn1);

    }


private void addButtonToTableCartQuantity(int activ_user_id) {
        TableColumn<products, Void> colBtn1 = new TableColumn("+");
        services_cart sc = new services_cart();
        Callback<TableColumn<products, Void>, TableCell<products, Void>> cellFactory = new Callback<TableColumn<products, Void>, TableCell<products, Void>>() {
            @Override
            public TableCell<products, Void> call(final TableColumn<products, Void> param) {
                final TableCell<products, Void> cell = new TableCell<products, Void>() {

                    private final Button btnplus = new Button();

                    {
                        ImageView btnimg = new ImageView("buttplus.png");
                        btnimg.setFitWidth(30);
                        btnimg.setFitHeight(30);
                        btnplus.setGraphic(btnimg);

                        btnplus.setOnAction((ActionEvent event) -> {
                            products data = getTableView().getItems().get(getIndex());

                            sc.update_panier_product_quantity(activ_user_id, data.getProduct_id(), data.getQuantity() + 1);
                            refrechTableCart(activ_user_id);
                            Double t=0.0;
                            refrech_tot_price(t, activ_user_id);
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

        colBtn1.setCellFactory(cellFactory);

        cart_table.getColumns().add(colBtn1);

    }

    private void addButtonToTableCartQuantityMinus(int activ_user_id) {
        TableColumn<products, Void> colBtn1 = new TableColumn("-");
        services_cart sc = new services_cart();
        Callback<TableColumn<products, Void>, TableCell<products, Void>> cellFactory = new Callback<TableColumn<products, Void>, TableCell<products, Void>>() {
            @Override
            public TableCell<products, Void> call(final TableColumn<products, Void> param) {
                final TableCell<products, Void> cell = new TableCell<products, Void>() {

                    private final Button btnplus = new Button();

                    {
                        ImageView btnimg = new ImageView("btnminus.png");
                        btnimg.setFitWidth(30);
                        btnimg.setFitHeight(30);
                        btnplus.setGraphic(btnimg);

                        btnplus.setOnAction((ActionEvent event) -> {
                            products data = getTableView().getItems().get(getIndex());
                            if (data.getQuantity() != 1) {
                                sc.update_panier_product_quantity(activ_user_id, data.getProduct_id(), data.getQuantity() - 1);
                            }
                            refrechTableCart(activ_user_id);
                            Double t=0.0;
                            refrech_tot_price(t, activ_user_id);
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

        colBtn1.setCellFactory(cellFactory);

        cart_table.getColumns().add(colBtn1);

    }

     void refrechTableCart(int activ_user_id) {
        services_cart sc = new services_cart();
        cartlist.clear();
        cartlist = sc.getInitialTableData_Cart(activ_user_id);
        cart_table.setItems(cartlist);

    }
    
     public void refrechTableorders(int activ_user_id) {
        services_history_orders h= new services_history_orders();
        orders_historylist.clear();
        orders_historylist = ho.getInitialTableData_Orders_History(activ_user_id);
        

    }
    

    public void create_ordersHistory_Table() {

        Stage stage = new Stage();
       AnchorPane root = new AnchorPane();
 root.setStyle("-fx-background-image: url('ordersbg.png');");
        Scene scene = new Scene(root, 1420, 620);
        TableView tableView = new TableView();

        TableColumn<orders, String> Column1 = new TableColumn<>("order_id");
        Column1.setMinWidth(240);

        TableColumn<orders, String> Column2 = new TableColumn<>("delivery address");
        Column2.setMinWidth(240);

        TableColumn<orders, String> Column3 = new TableColumn<>("Country");
        Column3.setMinWidth(150);

        TableColumn<orders, Date> Column4 = new TableColumn<>("Date");
        Column4.setMinWidth(240);

        TableColumn<orders, Double> Column5 = new TableColumn<>("Total Price");
        Column5.setMinWidth(150);

        TableColumn<orders, String> Column6 = new TableColumn<>("Status");
        Column6.setMinWidth(150);

        TableColumn<orders, String> Column7 = new TableColumn<>("Order Products");
        Column7.setMinWidth(150);
        
        tableView.getColumns().add(Column1);
        tableView.getColumns().add(Column2);
        tableView.getColumns().add(Column3);
        tableView.getColumns().add(Column4);
        tableView.getColumns().add(Column5);
        tableView.getColumns().add(Column6);
        tableView.getColumns().add(Column7);

        Column1.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("adr_livraison"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("country"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        Column6.setCellValueFactory(new PropertyValueFactory<>("status"));
        Column7.setCellValueFactory(new PropertyValueFactory<>("liste_produit"));
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
         
         Column1.setCellFactory(cellFactory7);
         Column7.setCellFactory(cellFactory7);
        tableView.setItems(orders_historylist);
        tableView.setMaxHeight(350);
        Button printbButton =new Button("");
        printbButton.setBackground(Background.EMPTY);
        printbButton.setPrefWidth(50);
       ImageView print=new ImageView("print.png");
       print.setFitWidth(50);
       print.setFitHeight(50);
       printbButton.setGraphic(print);
    root.getChildren().add(printbButton);
     printbButton.setLayoutX(1300);
     printbButton.setLayoutY(60);
     printbButton.setOnMouseEntered((MouseEvent me) -> {
                           printbButton.setCursor(Cursor.HAND);
                        });
     services_orders ser=new services_orders();
     printbButton.setOnAction(e->{
            try {
                ser.pdfs(activ_user_id);
            } catch (Exception ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(tableView);
        tableView.setLayoutY(140);
        tableView.setLayoutX(50);
      
        stage.setTitle("orders history");
        stage.setScene(scene);
        stage.show();

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

    public void create_checkout_page(int activ_user_id,double total_price) {
        Stage stage = new Stage();
        stage.setTitle("Checkout");
        StackPane root = new StackPane();
         GridPane gridPane = createRegistrationFormPane();
         addUIControls(gridPane,activ_user_id,total_price);
          Scene scene = new Scene(gridPane, 800, 500);
          stage.setScene(scene);
          stage.show();
    }
    
    public void addUIControls(GridPane gridPane,int activ_user_id,Double total_price) {
    // Add Header
    Label headerLabel = new Label("Checkout");
    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    gridPane.add(headerLabel, 0,0,2,1);
    GridPane.setHalignment(headerLabel, HPos.CENTER);
    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

    // Add delivery Label
    Label nameLabel = new Label("Delivery Adress : ");
    gridPane.add(nameLabel, 0,1);

    // Add Name Text Field
    TextField nameField = new TextField();
    nameField.setPrefHeight(40);
    gridPane.add(nameField, 1,1);


    // Add country Label
    Label emailLabel = new Label("Country : ");
    gridPane.add(emailLabel, 0, 2);

    // Add country Text Field
    TextField emailField = new TextField();
    emailField.setPrefHeight(40);
    gridPane.add(emailField, 1, 2);

 // Add country Label
    Label postcode = new Label("Post code : ");
    gridPane.add(postcode, 0, 3);

    // Add country Text Field
    TextField postcodeField = new TextField();
    emailField.setPrefHeight(40);
    gridPane.add(postcodeField, 1, 3);   

    

    // Add Submit Button
    Button submitButton = new Button("Confirm Order");
    submitButton.setPrefHeight(40);
    submitButton.setDefaultButton(true);
    submitButton.setPrefWidth(150);
    gridPane.add(submitButton, 0, 4, 2, 1);
    GridPane.setHalignment(submitButton, HPos.CENTER);
    GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

    submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your adress");
                    
                } 
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your country");
                    
                } 
                if(postcodeField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a postcode");
                    
                }
                String adress1 =nameField.getText(); 
                String country1=emailField.getText(); 
                int postcode1=Integer.parseInt(postcodeField.getText());
                services_cart ss=new services_cart();
                double pr=ss.total_price_calcul(activ_user_id);
                services_orders so=new services_orders(); so.add_order(activ_user_id,adress1 , country1, postcode1,pr);
                refrechTableCart(activ_user_id);
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Order Confirmed!", "your order is being prepared" );
                nameField.clear();
                emailField.clear();
                postcodeField.clear();
                Notifications notifictaionBuilder = Notifications.create()
                    .title(" Confirmation")
                    .text("Order Confirmed")
                    .graphic(null)
                    .position(Pos.TOP_RIGHT)
                    .onAction((ActionEvent event1) -> {
                        System.out.println("Clicked on notifictaion");
            });
            notifictaionBuilder.darkStyle();
            notifictaionBuilder.show();
            so.mailing_order(activ_user_id);
            }     
                 
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
        
    }
    
    public void refrech_tot_price(double total_price,int activ_user_id)
    {
        services_cart cc=new services_cart();
        total_price=cc.total_price_calcul(activ_user_id);
        
        tot_price.setText(String.valueOf(total_price));
    }
    
    
    
    
    
}
