package com.cmg.pl.listenner;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.c_mg.pl.selenium.PLAUTOTEST.PropertiesHelper;


public class SuiteListener implements ISuiteListener{

	public void onStart(ISuite suite) {
		
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("chay xong roi gui mail di em oi");
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "465";
		String mailFrom = "lan.ta@c-mg.com";
		String password = "19092011";

		// message info
		String mailTo = "lan.ta@c-mg.com,tabaolan1987@gmail.com";
		String subject = "Automation Test Result";
		String message = "<p>Dear all,<p>I send some attachments for you.There are the results of the automation daily test for Pensionline PROD today!";
		
		// attachments
		String[] attachFiles = new String[3];
		String path = PropertiesHelper.getKey("project.basedir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "Suite";
		File chrome = new File(path + File.separator + "ChromeTest.html");
		if(chrome.exists()){
			attachFiles[0] = chrome.getAbsolutePath();
		}
		File firefox = new File(path + File.separator + "FirefoxTest.html");
		if(firefox.exists()){
			attachFiles[1] = firefox.getAbsolutePath();
		}
		File ie = new File(path + File.separator + "IETest.html");
		if(ie.exists()){
			attachFiles[2] = ie.getAbsolutePath();
		}
		try {
			sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
					subject, message, attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}
	public static void sendEmailWithAttachments(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message, String[] attachFiles)
			throws AddressException, MessagingException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("automation@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("lan.ta@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("anh.nguyen@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("elaine.dimon@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("my.vu@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("caroline.schofield@c-mg.com"));
	
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					System.out.println(filePath);
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				multipart.addBodyPart(attachPart);
			}
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg,msg.getAllRecipients());
	}
}
