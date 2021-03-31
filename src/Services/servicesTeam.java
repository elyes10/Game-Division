/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entities.connecttoDb;
import entities.Teams;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iyadh
 */
public class servicesTeam {
    
    Connection c = connecttoDb.getInstance().getCnx();
    
    
    public void addteam(Teams t ) throws SQLException{
        Statement st;
        try {
           st = c.createStatement();
           String rec = " INSERT INTO `teams`(`team_id`, `team_name`, `team_logo`, `Team_Website`, `user1_id`, `user2_id`, `user3_id`, `user4_id`, `user5_id`) "
                   + "      VALUES ('"+t.getTeam_id()+"','"+t.getTeam_name()+"','"+t.getTeam_logo()+"','"+t.getTeam_Website()+"','"+t.getUser1_id()+"','"+t.getUser2_id()+"','"+t.getUser3_id()+"','"+t.getUser4_id()+"','"+t.getUser5_id()+"')";
           st.executeUpdate(rec);
            System.err.println("add successful");
        } catch (SQLException ex) {
            Logger.getLogger(servicesTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void addteam1(Teams t ) throws SQLException{
        Statement st;
        try {
           st = c.createStatement();
           String rec = " INSERT INTO `teams`(`team_name`, `team_logo`, `Team_Website`, `user1_id`, `user2_id`, `user3_id`, `user4_id`, `user5_id`) "
                   + "      VALUES ('"+t.getTeam_name()+"','"+t.getTeam_logo()+"','"+t.getTeam_Website()+"','"+t.getUser1_id()+"','"+t.getUser2_id()+"','"+t.getUser3_id()+"','"+t.getUser4_id()+"','"+t.getUser5_id()+"')";
           st.executeUpdate(rec);
            System.err.println("add successful");
        } catch (SQLException ex) {
            Logger.getLogger(servicesTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
  
      public void showTeams() {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("select * from teams");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println("Team [  team_id : " + rs.getInt(1) +   ",  team_name  " + rs.getString(2) +   ",  team_logo " + rs.getString(3) +", team_website "  +rs.getString(4)+" menber1_id "+rs.getInt(5)+" menber2_id "+rs.getInt(6)+" member3_id "+ rs.getInt(7)+" member4_id "+rs.getInt(7)+" member5_id "+ rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicesTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }      
            

public void updateTeams(int id, Teams t) {
        try {
            PreparedStatement pt = c.prepareStatement("UPDATE `teams` SET `team_name`=?,`team_logo`=?,`Team_Website`=?,`user1_id`=?,`user2_id`=?,`user3_id`=?,`user4_id`=?,`user5_id`=? WHERE team_id=?");

            pt.setString(1, t.getTeam_name());
            pt.setString(2, t.getTeam_logo());
            pt.setString(3,t.getTeam_Website());
            pt.setInt(4, t.getUser1_id());
            pt.setInt(5, t.getUser2_id());
            pt.setInt(6, t.getUser3_id());
            pt.setInt(7, t.getUser4_id());
            pt.setInt(8, t.getUser5_id());
            pt.setInt(9, id);
            pt.executeUpdate();
            System.err.println("update successful");

        } catch (SQLException ex) {
            Logger.getLogger(servicesTeam.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
    }
      

public void deleteTeams(Teams t) {
        PreparedStatement pt;
        try {
            pt = c.prepareStatement("delete from teams where team_id=? ");
            pt.setInt(1, t.getTeam_id());
            pt.executeUpdate();
            System.out.println("delete successful");

        } catch (SQLException ex) {
            Logger.getLogger(servicesTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Teams> getAll(){
    List<Teams> us = new ArrayList<>();
        PreparedStatement p;
        try {
        p = c.prepareStatement("select * from teams");
        ResultSet rs = p.executeQuery();
        while (rs.next()){
         //Teams u = new Teams(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
         Teams u = new Teams(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
         us.add(u);
            System.out.println("success");
            
        }    } catch (SQLException ex) {
            Logger.getLogger(servicesUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
    return us;
    }
    

    
    }

