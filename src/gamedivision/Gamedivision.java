/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision;

import Services.Service_mail;
import Services.servicesTeam;
import Services.servicesUser; 
import entities.Teams;
import entities.User;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author iyadh
 */
public class Gamedivision {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ParseException, SQLException{
        // TODO code application logic here
        User u1 = new User(56,"iyadhhh","jjkhh","kjfcn",4,"ckj","ycrjth","male");     
        
        //Service_mail mai =new Service_mail();
        //mai.send_mail("kurusakiichego13@gmail.com", "");
        
        
        //servicesUser su = new servicesUser();
          //su.adduser(u1);
       //su.showUser();
        //su.updateUser(56, u1);
       //su.deleteUser(u1);
       
       Teams t1= new Teams(1, "dfghjk", "team_logo", "Team_Website", 1, 2, 3, 4, 5);
       //servicesTeam st = new servicesTeam();
      // st.addteam(t1);
       //st.showTeams();
        //st.updateTeams(1, t1);
        //st.deleteTeams(t1);
    }
    
}
