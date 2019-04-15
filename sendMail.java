
package mailapp;

import java.util.Properties;
//import javax.mail.*;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;




public class sendMail {
    
    
    
     public static void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
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
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         //  message.setFrom(new InternetAddress(from));
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           JOptionPane.showMessageDialog(null,"message sent successfully");    
          } catch (MessagingException e) 
          {
             // throw new RuntimeException(e);
          }    
             
    }  
   /* public static  void sendMail(String from, String password, String message, String to){
        String host="216.58.201.68";
       // String host = "stmp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.user",from);
        props.put("mail.smtp.passowrd",password);
        props.put("mail.smtp.port",587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        
        MimeMessage mimemessage = new MimeMessage(session);
        try{
        mimemessage.setFrom(new InternetAddress(from));
        mimemessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//        InternetAddress[] toAddress = new InternetAddress[to.length()];
//        for(int i = 0; i<to.length();i++){
//            toAddress[i] = new InternetAddress(to[i]);
//        }
//        for(int i = 0; i<toAddress.length;i++){
//            mimemessage.setRecipient(Message.RecipientType.TO, toAddress[i]);
//            
//        }
        mimemessage.setSubject("mail using javamail api ");
            mimemessage.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "aizaz319@gmail.com" ,"aizazalishah100");
            transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
             //   transport.sendMessage(mimemessage, adrss);
            transport.close();
            JOptionPane.showMessageDialog(null, "Email Sent:");
            
            
          
            
            
        }
        catch(MessagingException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something went wrong:");
        }
        
       
  //  {//
//        Properties props = new Properties();
//        props.put("mail.smtp.host","smtp.gmail.com");
//        props.put("mail.smtp.port",587);
//        props.put("mail.smtp.auth","true");
//        props.put("mail.smtp.starttls.enable","true");
//      //  Session session = Session.getDefaultInstance(props, null);
//        Session session = Session.getDefaultInstance(props, new Authenticator()
//        {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(user, pass);
//            }
//        });
//       
//        
//            MimeMessage message = new MimeMessage(session);
//            try{
//            message.setFrom(new InternetAddress("user"));
//            
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//           // message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.setSubject(sub);
//            message.setText(msg);
//           // Transport transport = session.getTransport("smtp");
//            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Email Sent:");
//    }
//        catch(MessagingException e){
//         //   e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Something went wrong:");
//           // throw new RuntimeException(e);
//            
//        }
    }*/

}