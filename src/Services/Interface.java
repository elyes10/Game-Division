/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.product;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public interface Interface 
{
    void addproduct (product p);
   void deleteproduct (product p);
   void editproduct (product p);
   List<product> displayproduct();
   Map<Integer,String> countbycategories();
   Map<String,List<product>> classifybycategories();
   Map<Integer,String> countbyteams();
   Map<Integer,List<product>>classifybyteams();
   List<product> sortproduct();
   Map<String,product> peak();
   Map<String,product> minimum();

    /**
     *
     * @return
     */
   ObservableList<product> getInitialTableData();
    
}
