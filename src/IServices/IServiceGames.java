/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Games;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author farou
 */
public interface IServiceGames {
    public void ShowById(Games g);
    public void AddGames(Games g);
    public void DeleteGames(Games g);
    public List<Games>AfficherGames()throws SQLException;
    public void UpdateGames(Games g);
    public ObservableList<Games> getInitialTableData() ;
    
}
