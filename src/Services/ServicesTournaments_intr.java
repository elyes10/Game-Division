/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Games;
import Entities.Tournaments;
import Entities.Tournaments_intr;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.connecttoDb;

/**
 *
 * @author farou
 */
public class ServicesTournaments_intr implements IServices.IServicesTournaments_intr{
      Connection cnx;
   public ServicesTournaments_intr(){
   cnx=connecttoDb.getInstance().getCnx();
   
   
   }
  
    public void AddTournaments_inter(Tournaments_intr tr) {
       try {
           Statement stm=cnx.createStatement();
           String query="INSERT INTO `tournaments_intr`(`Tr_id`, `tr_cover`, `tr_link`) VALUES ('"+tr.getTr_id()+"','"+tr.getTr_cover()+"','"+tr.getTr_link()+"')";
           stm.executeUpdate(query);
           System.out.println("adjout réussie");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments_intr.class.getName()).log(Level.SEVERE, null, ex);
       }
        
                }
  
    public void DeleteTournaments_inter(Tournaments_intr tr) {
         try {
           Statement stm=cnx.createStatement();
           String query="DELETE  FROM `tournaments_intr` WHERE (`Tr_id`='"+tr.getTr_id()+"')";
           stm.executeUpdate(query);
             System.out.println("Suppression Résussite");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments_intr.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    
//    public List<Tournaments_intr> AfficherTournaments_inter() throws SQLException {
//       
//           Statement stm=cnx.createStatement();
//           String query="SELECT * FROM `tournaments_intr`";
//           ResultSet rst=stm.executeQuery(query);
//           List<Tournaments_intr>tournaments_intr = new ArrayList<>();
//           
//           while(rst.next())
//           {
//           Tournaments_intr tr=new Tournaments_intr();
//           tr.setTr_id(rst.getInt("Tr_id"));
//           tr.setTr_cover(rst.getString("tr_cover"));
//           tr.setTr_link(rst.getString("tr_link"));
//           tournaments_intr.add(tr);
//           }
// 
//       return tournaments_intr;
//    }

      @Override
 public void UpdateTournaments_inter(Tournaments_intr tr) {
       try {
           PreparedStatement pt = cnx.prepareStatement("UPDATE tournaments_intr SET Tr_id=?,tr_cover=?,tr_link=? where Tr_id = ?");
           pt.setInt(1,tr.getTr_id());
           pt.setString(2,tr.getTr_cover());
           pt.setString(3,tr.getTr_link());
           pt.setInt(4,tr.getTr_id());
           pt.executeUpdate(); 
            System.out.println("Update Réussi");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments_intr.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }
 
   /**
     *
     * @return
     */
   @Override

    public ObservableList<Tournaments_intr> getInitialTableData() {
        String sql = "SELECT * FROM tournaments_intr";
        ObservableList<Tournaments_intr> data = FXCollections.observableArrayList();
        try {
            PreparedStatement s = connecttoDb.getInstance().getCnx().prepareStatement(sql);
            s.executeQuery(sql);
            ResultSet res = s.executeQuery(sql);
            while (res.next()) {
               
                File file = new File(res.getString(2));
                Image imgg = new Image(file.toURI().toString()) {};
                ImageView imgView = new ImageView(imgg);
                imgView.setFitWidth(150);
                imgView.setFitHeight(80);
                Tournaments_intr tr = new Tournaments_intr(res.getInt(1), res.getString(2), res.getString(3));
                tr.setImageView(imgView);
                data.add(tr);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error in Building Data"+ex);
        }
        return data;
    }
 
}
