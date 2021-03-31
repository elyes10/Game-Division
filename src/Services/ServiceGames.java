/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Services.IServiceGames;
import entities.Games;
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
import entities.connecttoDb;

/**
 *
 * @author farou
 */
public class ServiceGames implements IServiceGames{
   Connection cnx;
   public ServiceGames(){
   cnx=connecttoDb.getInstance().getCnx();
   
   
   }
    @Override
    public void AddGames(Games g) {
       try {
           Statement stm=cnx.createStatement();
           String query="INSERT INTO `games`(`Game_name`, `Game_cover`, `Description`) VALUES ('"+g.getGame_name()+"','"+g.getGame_cover()+"','"+g.getDescription()+"')";
           stm.executeUpdate(query);
           System.out.println("adjout réussie");
       } catch (SQLException ex) {
           Logger.getLogger(ServiceGames.class.getName()).log(Level.SEVERE, null, ex);
       }
        
                
                }
  
    @Override
    public void DeleteGames(Games g) {
         try {
           Statement stm=cnx.createStatement();
           String query="DELETE  FROM `games` WHERE (`Game_id`='"+g.getGame_id()+"')";
           stm.executeUpdate(query);
             System.out.println("Suppression Résussite");
       } catch (SQLException ex) {
           Logger.getLogger(ServiceGames.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    
    @Override 
    public void ShowById(Games g)
    {
    try {
           Statement stm=cnx.createStatement();
           String query="Select * FROM `games` WHERE (`Game_id`='"+g.getGame_id()+"')";
           
           ResultSet rst=stm.executeQuery(query);
           Games ga = new Games();
           ga.setGame_id(rst.getInt("Game_id"));
           ga.setGame_name(rst.getString("Game_name"));
           ga.setGame_cover(rst.getString("Game_cover"));
           ga.setDescription(rst.getString("Description"));
           
           System.out.println("Affiche by Id Résussie");
       } catch (SQLException ex) {
           Logger.getLogger(ServiceGames.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }

    
    @Override
    public List<Games> AfficherGames() throws SQLException {
       
           Statement stm=cnx.createStatement();
           String query="SELECT * FROM `games` ";
           
           ResultSet rst=stm.executeQuery(query);
           List<Games>games = new ArrayList<>();
           
           while(rst.next())
           {
           Games g=new Games();
           g.setGame_id(rst.getInt("Game_id"));
           g.setGame_name(rst.getString("Game_name"));
           g.setGame_cover(rst.getString("Game_cover"));
           g.setDescription(rst.getString("Description"));
           games.add(g);
           
           }
 
       return games;
    }

    
    @Override
    public void UpdateGames(Games g) {
       try {
        
           PreparedStatement pt = cnx.prepareStatement("UPDATE games SET Game_id=?,Game_name=?,Game_cover=?,Description=? where Game_id = ?");
           pt.setInt(1,g.getGame_id());
           pt.setString(2,g.getGame_name());
           pt.setString(3,g.getGame_cover());
           pt.setString(4,g.getDescription());
           pt.setInt(5,g.getGame_id());
           pt.executeUpdate(); 
           System.out.println("Update Réussi");
       } catch (SQLException ex) {
           Logger.getLogger(ServiceGames.class.getName()).log(Level.SEVERE, null, ex);
       }
 
           
    }
    
    /**
     *
     * @return
     */
   @Override
    public ObservableList<Games> getInitialTableData() 
    {
           String sql="SELECT Game_id,Game_name,Game_cover,Description FROM games";      
           ObservableList<Games> data = FXCollections.observableArrayList();     
        try {
            PreparedStatement s = connecttoDb.getInstance().getCnx().prepareStatement(sql);
            s.executeQuery(sql);
            ResultSet res=s.executeQuery(sql);
            while(res.next())
            { 
                 File file = new File(res.getString(3));
                Image imgg = new Image(file.toURI().toString()) {};
                ImageView imgView = new ImageView(imgg);
                imgView.setFitWidth(150);
                imgView.setFitHeight(80);
               Games g=new Games(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));  
               g.setImageView(imgView);
               data.add(g);
            }   
            System.out.println(data);
            }
        catch(Exception ex)
          {
              System.out.println("Error in Building Data");             
          }
           return data;
    }
    
}
