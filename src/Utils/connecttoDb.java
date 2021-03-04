package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connecttoDb {
    
String password="";
    String login="root";
    String url="jdbc:mysql://localhost:3308/gamedivision";
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
}