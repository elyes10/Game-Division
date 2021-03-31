/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import entities.Games;
import entities.Tournaments;
import Services.IServicesTournaments;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import entities.connecttoDb;

/**
 *
 * @author farou
 */
public class ServicesTournaments implements IServicesTournaments{
     Connection cnx;
   public ServicesTournaments(){
   cnx=connecttoDb.getInstance().getCnx();
   
   
   }
  
    public void AddTournaments(Tournaments t) {
       try {
           Statement stm=cnx.createStatement();
           String querye= " INSERT INTO `tournaments`(`Tr_id`,`Tr_cover`, `Game_id`, `Team1_id`,`Team2_id`,`Team3_id`,`Team4_id`) VALUES ('"+t.getTr_id()+"','"+t.getTr_cover()+"','"+t.getGame_id()+"','"+t.getTeam1_id()+"','"+t.getTeam2_id()+"','"+t.getTeam3_id()+"','"+t.getTeam4_id()+"')";
           stm.executeUpdate(querye);
           System.out.println("ajout réussie");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments.class.getName()).log(Level.SEVERE, null, ex);
       }
        
                
                }
  
    public void DeleteTournaments(Tournaments t) {
         try {
           Statement stm=cnx.createStatement();
           String query="DELETE  FROM `tournaments` WHERE (`Tr_id`='"+t.getTr_id()+"')";
           

           
           stm.executeUpdate(query);
             System.out.println("Suppression Résussite");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public List<Tournaments> AfficherTournaments() throws SQLException {
       
           Statement stm=cnx.createStatement();
           String query="SELECT * FROM `tournaments`  ";
           ResultSet rst=stm.executeQuery(query);
           List<Tournaments>tournaments = new ArrayList<>();
           Games g = new Games();
            g.setGame_id(rst.getInt("Game_id"));
           while(rst.next())
           {
           Tournaments t=new Tournaments();
           t.setTr_id(rst.getInt("Tr_id"));
           t.setTr_cover(rst.getString("tr_cover"));
           t.setGames(g);
           t.setTeam1_id(rst.getInt("team1_id"));
           t.setTeam2_id(rst.getInt("team2_id"));
           t.setTeam3_id(rst.getInt("team3_id"));
           t.setTeam4_id(rst.getInt("team4_id"));
           tournaments.add(t);
           
           }
 
       return tournaments;
    }

   public  Map<Integer,String> countbyteams() {
          String sql="SELECT count(Tr_id),Game_name from tournaments INNER join games on games.Game_id=tournaments.Game_id group by Game_name" ;
         Map<Integer,String>m=new TreeMap();
        try {
            Statement s = connecttoDb.getInstance().getCnx().createStatement();
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
           
            while(res.next())
            { 
                m.put(res.getInt(1),res.getString(2));
                System.out.print("[");
                System.out.print(" "+res.getInt(1));
                System.out.print(" "+res.getString(2));
                System.out.print("]");
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ServicesTournaments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
        
    }
   
   public String getteamname(int id ) throws SQLException
   {
       String team_name = "";
         PreparedStatement pt = cnx.prepareStatement("SELECT team_name from teams where team_id="+id+"");
        ResultSet res = pt.executeQuery();
         while ( res.next())
         {
         team_name =res.getString(1);
         
         }
   return team_name;
   }
   
   public String getgamename(int id) throws SQLException
   {
        
             String game_name="";
             PreparedStatement pt = cnx.prepareStatement("SELECT Game_name from games where Game_id="+id+"");
             ResultSet res = pt.executeQuery();
             while ( res.next())
             {
                 game_name =res.getString(1);
                 
             }
             return game_name;
        
         }
   
   
   
   public void UpdateTournaments(Tournaments t) {
       try {
           Statement stm=cnx.createStatement();
        PreparedStatement pt = cnx.prepareStatement("UPDATE tournaments SET Tr_id=?,Tr_cover=?,Game_id=?,Team1_id=?,Team2_id=?,Team3_id=?,Team4_id=? where Tr_id = ?");           
        
           pt.setInt(1,t.getTr_id());
           pt.setString(2,t.getTr_cover());
           pt.setInt(3,t.getGames().getGame_id());
           pt.setInt(4,t.getTeam1_id());
           pt.setInt(5,t.getTeam2_id());
           pt.setInt(6,t.getTeam3_id());
           pt.setInt(7,t.getTeam4_id());
           pt.setInt(8,t.getTr_id());;
           
           pt.executeUpdate(); 
      
        System.out.println("Update Réussi");
       } catch (SQLException ex) {
           Logger.getLogger(ServicesTournaments.class.getName()).log(Level.SEVERE, null, ex);
       }
   
    }
      /**
     *
     * @return
     */
   @Override

    public ObservableList<Tournaments> getInitialTableData() {
        String sql = "SELECT * FROM tournaments ";
        ObservableList<Tournaments> data = FXCollections.observableArrayList();
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
                Tournaments t = new Tournaments(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7));
                t.setImageView(imgView);
                data.add(t);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error in Building Data"+ex);
        }
        return data;
    
    }
 
}
