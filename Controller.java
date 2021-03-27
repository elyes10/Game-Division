/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products;

import static gamedivision_products.AlertDialog.showSimpleAlert;
import gamedivision_products.entities.product;
import gamedivision_products.services.ProductsFunctions;
import gamedivision_products.services.favouritefunctions;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Controller implements Initializable {

    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    @FXML
    private ImageView img;
    @FXML
    private Button addonclick;
    @FXML
    private Button deleteonclick;
    @FXML
    private Button updateonclick;
    @FXML
    private Button statisticsonclick;
    @FXML
    private Button refreshonclick;
    @FXML
    private TextField searchbar;
    @FXML
    private TableView tableview;
    @FXML
    private TableColumn<Map, String> c1;
    @FXML
    private TableColumn<Map, String> c2;
    @FXML
    private TableColumn<Map, String> c3;
    @FXML
    private TableColumn<Map, String> c4;
    @FXML
    private TableColumn<Map, String> c5;
    @FXML
    private TableColumn<Map, String> c6;
    @FXML
    private VBox y;
    @FXML
    private ImageView searchicon;
    @FXML
    private Label l1;
    @FXML
    private TextField t1;
    @FXML
    private Label l2;
    @FXML
    private TextField t2;
    @FXML
    private Label l3;
    @FXML
    private TextField t3;
    @FXML
    private Label l4;
    @FXML
    private TextField t4;
    @FXML
    private Label l5;
    @FXML
    private TextField t5;
    @FXML
    private Button statisticsonclick1;
    @FXML
    private Button statisticsonclick22;
    @FXML
    private Button classification;
    @FXML
    private Button retrn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.display();
        // TODO
    }    
private void display()
{
        tableview.getItems().clear();
         c1.setCellValueFactory(new MapValueFactory<>("product_name"));

//Column2 = new TableColumn<>("team_id");
c2.setCellValueFactory(new MapValueFactory<>("team_id"));

//Column3 = new TableColumn<>("price");
c3.setCellValueFactory(new MapValueFactory<>("price"));

//Column4 = new TableColumn<>("Category");
c4.setCellValueFactory(new MapValueFactory<>("Category"));

//Column5 = new TableColumn<>("Quantity");
c5.setCellValueFactory(new MapValueFactory<>("Quantity"));
//Column6 = new TableColumn<>("img");
c6.setCellValueFactory(new MapValueFactory<>("img"));
//select.setCellValueFactory(new MapValueFactory<>("select product"));
//id.setCellValueFactory(new MapValueFactory<>("id"));
ProductsFunctions pf=new  ProductsFunctions();
ObservableList<product> l=pf.getInitialTableData();
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();

for(int i=0;i<l.size();i++)
{
    Button b=new Button("select");

    product p=new product(l.get(i).getProduct_name() ,l.get(i).getPrice(), l.get(i).getTeam_id() ,l.get(i).getCategory(), l.get(i).getQuantity(),l.get(i).getImg());
    p.setProduct_id(l.get(i).getProduct_id());
    Map<String, Object> item1 = new HashMap<>();
item1.put("product_name",p.getProduct_name() );
item1.put("team_id" , p.getTeam_id());
item1.put("price" , p.getPrice());
item1.put("Category" , p.getCategory());
item1.put("Quantity" , p.getQuantity());
item1.put("img" , p.getImageView());
//item1.put("select product",b);
//item1.put("id",p.getid());
//item1.put("select product",p.getid());
//b.setOnAction(e->this.selectitem());
   // System.out.println(this.selectitem().get(0));
items.add(item1);
}
tableview.getItems().addAll(items);
tableview.refresh();

}
    @FXML
    private void addtheproduct(ActionEvent event) {
          t1.getText();
        t2.getText();
        t3.getText();
        t4.getText();
        t5.getText();
        ProductsFunctions pf=new  ProductsFunctions();
        System.out.println(t1.getText()+t2.getText()+t3.getText()+t4.getText()+t5.getText());
        product p;
        int id=pf.getteamid(t3.getText());
        double d=Double.parseDouble(t2.getText());
        int i=Integer.parseInt(t5.getText());
   p=new product(t1.getText(),d,id,t4.getText(),i,this.uploadimage());
        
        pf.addproduct(p);
        this.display();
      //  showSimpleAlert("Products", "product added");
        //System.out.println("a");
    }
     private String uploadimage() {
         Stage primaryStage=new Stage();    
primaryStage.setTitle("JavaFX App");

        FileChooser fileChooser = new FileChooser();
        File f=fileChooser.showOpenDialog(primaryStage);
        System.out.println(f.getAbsoluteFile());
fileChooser.setTitle("Open Resource File");
fileChooser.showOpenDialog(primaryStage);
        
       return   f.getAbsoluteFile().toString();
    }

    @FXML
    private void deletetheproduct(ActionEvent event) {
         t1.getText();
        product p;
       // double d=Double.parseDouble(t2.getText());
      //  int i=Integer.parseInt(t5.getText());
         p=new product(t1.getText(),0,0,"",0,"");
         
        ProductsFunctions pf=new  ProductsFunctions();
        pf.deleteproduct(p);
        this.display();
    }

    @FXML
    private void updatetheproduct(ActionEvent event) {
         t1.getText();
        product p;
                ProductsFunctions pf=new  ProductsFunctions();

        double d=Double.parseDouble(t2.getText());
        int i=Integer.parseInt(t5.getText());
        int id=pf.getteamid(t3.getText());
         p=new product(t1.getText(),d,id,t4.getText(),i,this.uploadimage());
         
        pf.editproduct(p);
        this.display();
    }

    @FXML
    private void stats(ActionEvent event) 
    {
     Stage stage=new Stage();
      ProductsFunctions pf =new  ProductsFunctions(); 
      
    
        Map<Integer,String>m=pf.countbyteams();
        System.out.println(m.keySet().toString()+m.values());
         CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList((m.values())));
      xAxis.setLabel("team_name"); 
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("number of products per team");
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("");
      XYChart.Series<String,Number> series = new XYChart.Series<>();
      series.setName("Number of products by teams"); 
     for (Map.Entry<Integer,String> entry : m.entrySet()) 
     {
       System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        series.getData().add(new XYChart.Data<>(entry.getValue(),entry.getKey()));
     }
  //    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      barChart.getData().addAll(series);
      Group root = new Group(barChart);
      Scene scene = new Scene(root, 600, 400);

      stage.setTitle("Bar Chart");
     
      stage.setScene(scene);
      
      stage.show();    
    }

    @FXML
    private void refresh(ActionEvent event) {
        tableview.getItems().clear();
         c1.setCellValueFactory(new MapValueFactory<>("product_name"));

//Column2 = new TableColumn<>("team_id");
c2.setCellValueFactory(new MapValueFactory<>("team_id"));

//Column3 = new TableColumn<>("price");
c3.setCellValueFactory(new MapValueFactory<>("price"));

//Column4 = new TableColumn<>("Category");
c4.setCellValueFactory(new MapValueFactory<>("Category"));

//Column5 = new TableColumn<>("Quantity");
c5.setCellValueFactory(new MapValueFactory<>("Quantity"));
//Column6 = new TableColumn<>("img");
c6.setCellValueFactory(new MapValueFactory<>("img"));
//select.setCellValueFactory(new MapValueFactory<>("select product"));
//id.setCellValueFactory(new MapValueFactory<>("id"));
ProductsFunctions pf=new  ProductsFunctions();
ObservableList<product> l=pf.getInitialTableData();
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();

for(int i=0;i<l.size();i++)
{
    Button b=new Button("select");

    product p=new product(l.get(i).getProduct_name() ,l.get(i).getPrice(), l.get(i).getTeam_id() ,l.get(i).getCategory(), l.get(i).getQuantity(),l.get(i).getImg());
    p.setProduct_id(l.get(i).getProduct_id());
    Map<String, Object> item1 = new HashMap<>();
item1.put("product_name",p.getProduct_name() );
item1.put("team_id" , p.getTeam_id());
item1.put("price" , p.getPrice());
item1.put("Category" , p.getCategory());
item1.put("Quantity" , p.getQuantity());
item1.put("img" , p.getImageView());
//item1.put("select product",b);
//item1.put("id",p.getid());
//item1.put("select product",p.getid());
//b.setOnAction(e->this.selectitem());
   // System.out.println(this.selectitem().get(0));
items.add(item1);
}
tableview.getItems().addAll(items);
tableview.refresh();
    }


    @FXML
    private void searchproduct(ActionEvent event) {
        searchbar.getText();
        ProductsFunctions pf=new  ProductsFunctions();
        System.out.println(pf.searchProduct(searchbar.getText()));
        Stage stage=new Stage();
         StackPane root= new StackPane();
       
       Scene scene = new Scene(root);
         TableView tableView = new TableView();

TableColumn<Map, String> Column1 = new TableColumn<>("product_name");
Column1.setCellValueFactory(new MapValueFactory<>("product_name"));

TableColumn<Map, String> Column2 = new TableColumn<>("team_id");
Column2.setCellValueFactory(new MapValueFactory<>("team_id"));

TableColumn<Map, String> Column3 = new TableColumn<>("price");
Column3.setCellValueFactory(new MapValueFactory<>("price"));

TableColumn<Map, String> Column4 = new TableColumn<>("Category");
Column4.setCellValueFactory(new MapValueFactory<>("Category"));

TableColumn<Map, String> Column5 = new TableColumn<>("Quantity");
Column5.setCellValueFactory(new MapValueFactory<>("Quantity"));
TableColumn<Map, String> Column6 = new TableColumn<>("img");
Column6.setCellValueFactory(new MapValueFactory<>("img"));
tableView.getColumns().add(Column1);
tableView.getColumns().add(Column2);
tableView.getColumns().add(Column3);
tableView.getColumns().add(Column4);
tableView.getColumns().add(Column5);
tableView.getColumns().add(Column6);

ObservableList<product> l=pf.searchProduct(searchbar.getText());
ObservableList<Map<String, Object>> items =
    FXCollections.<Map<String, Object>>observableArrayList();
for(int i=0;i<l.size();i++)
{
    System.out.println();
product p=new product(l.get(i).getProduct_name() ,l.get(i).getPrice(), l.get(i).getTeam_id() 
        ,l.get(i).getCategory(), l.get(i).getQuantity(),l.get(i).getImg());
Map<String, Object> item1 = new HashMap<>();
item1.put("product_name",p.getProduct_name() );
item1.put("team_id" , p.getTeam_id());
item1.put("price" , p.getPrice());
item1.put("Category" , p.getCategory());
item1.put("Quantity" , p.getQuantity());
item1.put("img" , p.getImageView());
items.add(item1);
}



tableView.getItems().addAll(items);
root.getChildren().add(tableView);
        
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void searching(MouseEvent event) {
     
    }

    @FXML
    private void stats2(ActionEvent event) {
          Stage stage=new Stage();
       ProductsFunctions pf=new  ProductsFunctions();
            Map<Integer,String>m=pf.countbycategories();
            System.out.println(m.keySet().toString()+m.values());
             CategoryAxis xAxis = new CategoryAxis();  
          xAxis.setCategories(FXCollections.<String>
          observableArrayList((m.values())));
          xAxis.setLabel("category");

          NumberAxis yAxis = new NumberAxis();
          yAxis.setLabel("Nb%");


          //Creating the Bar chart
          BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
          barChart.setTitle("");

          //Prepare XYChart.Series objects by setting data 
          XYChart.Series<String,Number> series = new XYChart.Series<>();
          series.setName("Number of products by Category"); 
         for (Map.Entry<Integer,String> entry : m.entrySet()) 
         {
           System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            series.getData().add(new XYChart.Data<>(entry.getValue(),entry.getKey()));
         }
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Fiat");
      series1.getData().add(new XYChart.Data<>("Speed", 1.0));
      series1.getData().add(new XYChart.Data<>("User rating", 3.0));
      series1.getData().add(new XYChart.Data<>("Milage", 5.0));
      series1.getData().add(new XYChart.Data<>("Safety", 5.0));
        
      
              
      //Setting the data to bar chart       
      barChart.getData().addAll(series);
        
      //Creating a Group object 
      Group root = new Group(barChart);
        
      //Creating a scene object
      Scene scene = new Scene(root, 600, 400);

      //Setting title to the Stage
      stage.setTitle("Bar Chart");
        
      //Adding scene to the stage
      stage.setScene(scene);
        
      //Displaying the contents of the stage
      stage.show();   
    }

    @FXML
    private void stats3(ActionEvent event) 
    {
             Stage stage=new Stage();
       ProductsFunctions pf=new  ProductsFunctions();
        favouritefunctions f=new favouritefunctions();
        Map<Integer,String>m=f.countFavouriteProductsbyUser();
        System.out.println(m.keySet().toString()+m.values());
         CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList((m.values())));
      xAxis.setLabel("User_name");
       
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("Nb  of favourite products per User");
       
    
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("");
        
      //Prepare XYChart.Series objects by setting data 
      XYChart.Series<String,Number> series = new XYChart.Series<>();
      series.setName("Number of Favouriteproducts by User"); 
     for (Map.Entry<Integer,String> entry : m.entrySet()) 
     {
       System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        series.getData().add(new XYChart.Data<>(entry.getValue(),entry.getKey()));
     }
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Fiat");
      series1.getData().add(new XYChart.Data<>("Speed", 1.0));
      series1.getData().add(new XYChart.Data<>("User rating", 3.0));
      series1.getData().add(new XYChart.Data<>("Milage", 5.0));
      series1.getData().add(new XYChart.Data<>("Safety", 5.0));
        
      
              
      //Setting the data to bar chart       
      barChart.getData().addAll(series);
        
      //Creating a Group object 
      Group root = new Group(barChart);
        
      //Creating a scene object
      Scene scene = new Scene(root, 600, 400);

      //Setting title to the Stage
      stage.setTitle("Bar Chart");
        
      //Adding scene to the stage
      stage.setScene(scene);
        
      //Displaying the contents of the stage
      stage.show();      
    }

    @FXML
    private void classify(ActionEvent event) 
    {
              ProductsFunctions pf=new  ProductsFunctions();
    //    lb11.setText("****nb products by category****"+pf.countbycategories());
      //  lb12.setText("****products by catg****"+pf.classifybycategories().toString()+"***poducts by team***"+pf.classifybyteams().toString()+pf.countbycategories().toString()+pf.minimum().toString()+pf.peak().toString());
       Stage primaryStage=new Stage(); 
       favouritefunctions f=new favouritefunctions();
primaryStage.setTitle("JavaFX App");
StackPane root = new StackPane();
       // productsFunctions pf=new  productsFunctions();
        Label lb=new Label();
        lb.setText("**** products by category****\n"+pf.minimum().toString()+"\n"
                
               //+"FavouriteProducts by User "+f.classify()+"\n"
                +"***poducts by team\n***"+pf.peak()+"\n"
                );
                root.getChildren().add(lb);
      Scene scene = new Scene(root, 100, 100);
       primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @FXML
    private void returntoadminmenu(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("adminsmenu.fxml"));;
                 
                 Parent root = loader.load();
              Scene scene = new Scene(root);
        
        // controller2.setid(f.login(t.getText(),t2.getText()));
        
        Stage st=new Stage();
        st.setScene(scene);
        st.initStyle(StageStyle.UNDECORATED);
        st.show();
    }
    
}
