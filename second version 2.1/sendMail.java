
package mailapp;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


public class sendMail {
    
    public static void send(String from,String password,String to,String sub,String msg){
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
          //compose message    
          try {    
           Message message = new MimeMessage(session); 
           Multipart multipart = new MimeMultipart();  
       //    message.addRecipient(Message.RecipientType.TO,new InternetAddress(this.sendToText.getText().toString()));
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
           message.setFrom(new InternetAddress(from));
           message.setSubject(sub);
           
           
           //3) create MimeBodyPart object and set your message text     
      MimeBodyPart messageBodyPart = new MimeBodyPart();  
    messageBodyPart.setText(msg);
    
    multipart.addBodyPart(messageBodyPart); 
    
  
    message.setContent(multipart);
     
           //send message  
           Transport.send(message);    
           JOptionPane.showMessageDialog(null,"message sent successfully");  
          
          } catch (MessagingException e) 
          {
             // throw new RuntimeException(e);
              JOptionPane.showMessageDialog(null,"Something Went Wrong"); 
          }
        
    }
    
}
