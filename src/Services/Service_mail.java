/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.util.Properties;  
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;  
import javax.mail.internet.*;

/**
 *
 * @author Asus
 */
public class Service_mail {
    public void send_mail(String mail,String nom)
    {
        String host="smtp.gmail.com";  
  final String user="iyadh.cherni@esprit.tn";//change accordingly  
  final String password="181JMT0713iyadh";//change accordingly  
    
  String to=mail;//change accordingly  
  
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
     message.setSubject("Gamedivision");  
     message.setText("test de l'api mail");  
       MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<H1>Mail</H1><img src=\"cid:image\">";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);

         



    
    
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
        
    }
    
    }