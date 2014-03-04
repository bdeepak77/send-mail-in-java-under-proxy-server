package javaapplication8;

 
import java.net.URLDecoder;
import java.util.Properties;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class JavaApplication8 {
 
	public static void main(String[] args) {
                String a = "http://en.wikipedia.org/wiki/El%C3%A1n_(recording_artist)";
		final String username = "networkprojectiith@gmail.com";
		final String password = "vikashamitdeepak";
                //a = URLDecoder.decode(a, "utf-8");
                try {
            System.out.println(URLDecoder.decode(a , "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
                //System.out.println(a);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cs11b038@iith.ac.in"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("cs11b038@iith.ac.in"));
			message.setSubject("Fucker Guthal");
			message.setText("Dear Yashasvi,"
				+ "\n\n Congrats for qualcomm,,,Party to de sale kutte");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}