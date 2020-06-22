
package AutorisationPackage;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSendService {
      final String senderEmail = "info.huntkingdom@gmail.com";
 final String senderPassword = "Switch123";
 final String emailSMTPserver = "smtp.tunet.tn";
 final String emailServerPort ="587";
  String receiverEmail = null;
 String emailSubject = null;
 String emailBody = null;

 
  public EmailSendService(){}
  
 public EmailSendService(String receiverEmail, String Subject, String message) {
        this.receiverEmail = receiverEmail;
        this.emailSubject = Subject;
        this.emailBody = message;
 
        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmail);
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port",emailServerPort);
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.starttls.required", "true");
  
 
        SecurityManager security = System.getSecurityManager();
        
     System.out.println("sds");
        try {
             Authenticator auth = new SMTPAuthenticator();
             Session session = Session.getInstance(props, auth);
 
             Message msg = new MimeMessage(session);
             msg.setText(emailBody);
             msg.setSubject(emailSubject);
             msg.setFrom(new InternetAddress(senderEmail));
             msg.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(this.receiverEmail));
             Transport.send(msg);
             System.out.println("send successfully");
       } catch (Exception ex) {
             System.err.println("Error occurred while sending.!");
       }
 
 }

    public void SendE_mail(String email, String messageS, String Subject) throws AddressException, MessagingException {
       String host = "smtp.gmail.com";
            String user = "info.huntkingdom@gmail.com";
            String pass = "Switch123";
            String to = email;
            String from = "info.huntkingdom@gmail.com";
            String subject =Subject;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageS);

            javax.mail.Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("Email envoyé");
    }
 
 private class SMTPAuthenticator extends javax.mail.Authenticator {
 
         @Override
         public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
         }
 }
}