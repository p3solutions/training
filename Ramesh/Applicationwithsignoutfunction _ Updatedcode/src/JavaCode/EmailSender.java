package JavaCode;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class EmailSender  {
	public static String date() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date(); 
		 String todaydate=formatter.format(date);
		return todaydate;
		
	}
	
	public static void mailFunction(String License_Id,String UserName,String ApplicationName,String Email) {
		String newline = System.lineSeparator();
			String to = Email;
			System.out.println(to);

	        // Sender's email ID needs to be mentioned
	        String from = "rameshinfotech777@gmail.com";
	        System.out.println(from);

	        // Assuming you are sending email using Gmail's SMTP server
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = new Properties();

	        // Setup mail server
	        properties.setProperty("mail.smtp.host", host);
	        properties.setProperty("mail.smtp.port", "587"); // Gmail SMTP port for TLS
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable TLS

	        // Create a Session object with authentication
	        Session session = Session.getInstance(properties, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("rameshinfotech777@gmail.com", "uxfi ouhh hsmg ctip");
	            }
	        });

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("Regards "+ApplicationName+" purchased Successfully");

	            // Now set the actual message
	            message.setText("Hi "+UserName+"!"+newline+"          You Purchased the "+ApplicationName+"("+License_Id+") on "+date()+" Successfully. Thanks for Puchase this Application. "+newline+newline+newline+"                                                             All the Best");

	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	}
	
	public static void mailFunctionAdmin(String License_Id,String UserName,String ApplicationName,String Email) {
			String newline = System.lineSeparator();
			
			String to = "rameshinfotech777@gmail.com";

	        // Sender's email ID needs to be mentioned
	        String from =Email;
	        System.out.println(from);

	        // Assuming you are sending email using Gmail's SMTP server
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = new Properties();

	        // Setup mail server
	        properties.setProperty("mail.smtp.host", host);
	        properties.setProperty("mail.smtp.port", "587"); // Gmail SMTP port for TLS
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable TLS

	        // Create a Session object with authentication
	        Session session = Session.getInstance(properties, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("rameshinfotech777@gmail.com", "uxfi ouhh hsmg ctip");
	            }
	        });

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("Regards "+ApplicationName+" purchased by "+UserName+" Successfully");

	            // Now set the actual message
	            message.setText("Hi Admin! "+ newline +"          "+ApplicationName+"("+License_Id+") is purchased by "+UserName+ " on "+date()+" Successfully.");

	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	}

	public static void mailFunctionforUpdateforAdmin(String license_Id, String userName, String applicationName,
		String renewed_date, String renewal_date, String email,String review) {
		String newline = System.lineSeparator();
		
		String to = "rameshinfotech777@gmail.com";

        // Sender's email ID needs to be mentioned
        String from =email;

        // Assuming you are sending email using Gmail's SMTP server
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = new Properties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // Gmail SMTP port for TLS
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create a Session object with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rameshinfotech777@gmail.com", "uxfi ouhh hsmg ctip");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Regards Update of "+applicationName+" by "+userName);

            // Now set the actual message
            message.setText("Hi Admin! "+ newline +"         "+applicationName+"("+license_Id+") is update by "+userName+ " from "+renewed_date+" to "+renewal_date+" on "+date()+" Successfully."+newline+newline+newline+"User "+userName+" review about application : "+newline+review);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
	}

	public static void mailFunctionforUpdate(String license_Id, String userName, String applicationName,
			String renewed_date, String renewal_date, String email,String review) {
String newline = System.lineSeparator();
		
		String to = email;

        // Sender's email ID needs to be mentioned
        String from ="rameshinfotech777@gmail.com";

        // Assuming you are sending email using Gmail's SMTP server
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = new Properties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // Gmail SMTP port for TLS
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create a Session object with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rameshinfotech777@gmail.com", "uxfi ouhh hsmg ctip");
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Regards Update of "+applicationName);

            // Now set the actual message
            message.setText("Hi "+userName+"! "+ newline +" "          +applicationName+"("+license_Id+") is update from "+renewed_date+" to "+renewal_date+" on "+date()+" Successfully."+newline+newline+newline+"Review about application : "+newline+review);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
		
	}
}

