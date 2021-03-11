/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedivision;

//import Services.Service_mail;
//import Services.servicesTeam;
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
        User u1 = new User((int) Math.random(),"elesssf","zarradf","mailll",25,"xxxx","zzz","zzz");     
        
      //  Service_mail mai =new Service_mail();
      //  mai.send_mail("fakhreddine.ghalleb@esprit.tn", "");
        
        
        servicesUser su = new servicesUser();
          //su.adduser(u1);
       //su.showUser();
        //su.updateUser(25, u1);
       //su.deleteUser(u1);
       
       Teams t1= new Teams(11, "aaaaaaaaaaaaaaa", "team_logo", "Team_Website", 1, 2, 3, 4, 5);
       //servicesTeam st = new servicesTeam();
      //st.addteam(t1);
      // st.showTeams();
       // st.updateTeams(11, t1);
        //st.deleteTeams(t1);
    }
    
}
