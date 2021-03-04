/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP OMEN
 */
public class connecttoDb {
    String password="";
    String login="root";
    String url="jdbc:mysql://localhost:3306/gamedivision";
    Connection connection;
    public static connecttoDb instance;
    connecttoDb()
    {
       

        try 
        {
            connection=DriverManager.getConnection(url, login, password);
            
            System.out.println("connected");
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(connecttoDb.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
public Connection getCnx()
{
return connection;   
}
public static connecttoDb getInstance()
{
   if (instance==null)
   {
       instance =new connecttoDb();
       
   }
   return instance;
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        connecttoDb.getInstance().getCnx();
    }
    
    
}
