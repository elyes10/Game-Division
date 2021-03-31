/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Utils.connecttoDb;
import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author iyadh
 */
public class LoginUserController implements Initializable {
    
     @FXML
    private TextField tfemail;
    @FXML
    private PasswordField tfpwd;
    @FXML
    private Button loginbtn ;
    @FXML
    private Button signupbtn ;
    @FXML
    private Button fgp;

 
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    Connection c = connecttoDb.getInstance().getCnx();
    Stage dialogStage = new Stage();
    Scene scene;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    @FXML
     public void loginAction(ActionEvent event) throws Exception{
        String email = tfemail.getText();
        String password = tfpwd.getText();
    
  
    
  
                    PreparedStatement st = (PreparedStatement) c.prepareStatement("Select User_Email, User_password from users where User_Email=? and User_password=?");
   try {
                    st.setString(1, email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                       
                        //Scene ah = new Scene();
                        //ah.setTitle("Welcome");
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                         Stage primaryStage = new Stage();
                         
         Parent root = FXMLLoader.load(getClass().getResource("ShowUsers.fxml"));
         Scene scene = new Scene(root);
            
            primaryStage.setTitle("Acceuil");
            primaryStage.setScene(scene);
            primaryStage.show();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

    
    
     }


    
    
    
    @FXML
    private void SignUp(ActionEvent event){
   
         Stage primaryStage = new Stage();
         Parent root;
         try {
             root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
             Scene scene = new Scene(root);
            
            primaryStage.setTitle("Sign Up Page");
            primaryStage.setScene(scene);
            primaryStage.show();
         } catch (IOException ex) {
             Logger.getLogger(LoginUserController.class.getName()).log(Level.SEVERE, null, ex);
         }
}

    
    
        @FXML
    private void send_mail(ActionEvent event)
    {
        String host="smtp.gmail.com";  
  final String user="iyadh.cherni@esprit.tn";//change accordingly  
  final String password="181JMT0713iyadh";//change accordingly  
    String email = tfemail.getText();
  String to=email;//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true"); 
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
         return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Pi_dev");  
     message.setText("test de l'api mail");  
       MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "Reset Password";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);
         
         messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(
            "C:/Users/iyadh/Desktop/pi_ppx/lol.png");

         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Content-ID", "<image>");

         multipart.addBodyPart(messageBodyPart);

         

         // put everything together
         message.setContent(multipart);
    //send the message  
    
    
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
        
    }
} 