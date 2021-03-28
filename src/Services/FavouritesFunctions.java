/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Map;
import javafx.collections.ObservableList;
import entities.product;

/**
 *
 * @author LENOVO
 */
public interface FavouritesFunctions {
    void AddproducttoFavourites(int i,int j);
    void DeleteproductfromFavourites(int i,int j);
     Map<Integer,String> countFavouriteProductsbyUser();
     Map<String,String> classify();
     int getiduser(String n);
     ObservableList<product> getInitialTableData(int i);
}
