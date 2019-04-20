
package mailapp;

import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.activation.*;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
//import javax.mail.*;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;




public class sendMail {
    
   
    public static void send(String from,String password,String to,String sub,String msg,String attachment_path1,
           String attachment_path2){  
           
            
   Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          try{
               MimeMessage message = new MimeMessage(session); 
           Multipart multipart = new MimeMultipart();
            InternetAddress[] addresses = InternetAddress.parse(to);
         message.addRecipients(Message.RecipientType.TO, addresses);
          message.setFrom(new InternetAddress(from));
//           
                 message.setSubject(sub);
           
              
           //3) create MimeBodyPart object and set your message text     
      MimeBodyPart messageBodyPart = new MimeBodyPart();  
    messageBodyPart.setText(msg); 
  //  Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart); 
    
   DataSource source = new FileDataSource(attachment_path1);
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 //  messageBodyPart.setDataHandler(new DataHandler(source));
  
   messageBodyPart2.setDataHandler(new DataHandler(source));
   messageBodyPart2.setFileName(attachment_path2);
   
   multipart.addBodyPart(messageBodyPart2);
    message.setContent(multipart);
 
         //     }
         Transport.send(message);
         JOptionPane.showMessageDialog(null,"The Message sent with attachments to "+to); 
          }
              
          
          catch(Exception e){
              
          }
         
         
   }

     }
     
     

