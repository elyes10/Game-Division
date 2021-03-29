/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Tournaments;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author farou
 */
public interface IServicesTournaments {
    public void AddTournaments(Tournaments t);
    public void DeleteTournaments(Tournaments t);
    public List<Tournaments>AfficherTournaments()throws SQLException;
    public void UpdateTournaments(Tournaments t);
    public ObservableList<Tournaments> getInitialTableData(); 

}
