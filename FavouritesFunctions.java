/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision_products.services;

import java.util.Map;
import javafx.collections.ObservableList;
import gamedivision_products.entities.product;
import java.util.List;

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

    public int login(String text, String text0);

    public List<String> getActiveUser();
}
