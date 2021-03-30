/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Games;
import Entities.Tournaments;
import Entities.Tournaments_intr;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author farou
 */
public interface IServicesTournaments_intr {
    public void AddTournaments_inter(Tournaments_intr tr);
    public void DeleteTournaments_inter(Tournaments_intr tr);
    public void UpdateTournaments_inter(Tournaments_intr tr);
    public ObservableList<Tournaments_intr> getInitialTableData();
}

