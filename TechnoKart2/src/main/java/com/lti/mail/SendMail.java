package com.lti.mail;

import java.util.*;

import javax.websocket.Session;
import javax.activation.*;

public class SendMail {
	public static void main(String[] args) {

		String from = "techno.kart.psvm@gmail.com";
		String to = "u_email";
		String password = "psvm@123";
		String host =  "smtp.gmail.com";
		String port = "587";
		

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		
		
		
		
		
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("HI");
			message.setText("How r u?");
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			System.out.println(e);
			
		}

		
	}
}
