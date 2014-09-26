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

import com.c_mg.pl.selenium.PLAUTOTEST.FolderZiper;
import com.c_mg.pl.selenium.PLAUTOTEST.PropertiesHelper;

public class SuiteListener implements ISuiteListener {

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
		String subject = "Automation Daily Test Result";
		String message = "<p>Dear all,<p>This is the automation test for PL PROD daily test result.<p>Kind regards,<p>Lan Ta";

		String folderTarget = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "target";

		// delete folder unnecessary
		try {
			File folderTestClasses = new File(folderTarget + File.separator
					+ "test-classes");
			delete(folderTestClasses);
			File folderMavenStatus = new File(folderTarget + File.separator
					+ "maven-status");
			delete(folderMavenStatus);
			File folderSurefire = new File(folderTarget + File.separator
					+ "surefire");
			delete(folderSurefire);
			File folderClasses = new File(folderTarget + File.separator
					+ "classes" + File.separator + "com");
			delete(folderClasses);
		} catch (IOException e) {
			System.out.println("can not delete folder : " + e.getMessage());
			e.printStackTrace();
		}

		// attachments
		try {
			String attachFiles = new String();

			String zipFile = PropertiesHelper.getKey("project.basedir")
					+ File.separator + "result.zip";
			FolderZiper.zipFolder(folderTarget, zipFile);
			File fileZip = new File(zipFile);
			if (fileZip.exists()) {
				attachFiles = fileZip.getAbsolutePath();
			}
			sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
					subject, message, attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {
			// directory is empty, then delete it
			if (file.list().length == 0) {
				file.delete();
				System.out.println("Directory is deleted : "
						+ file.getAbsolutePath());
			} else {
				// list all the directory contents
				String files[] = file.list();
				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);
					// recursive delete
					delete(fileDelete);
				}
				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : "
							+ file.getAbsolutePath());
				}
			}
		} else {
			// if file, then delete it
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	public static void sendEmailWithAttachments(String host, String port,
			final String userName, final String password, String toAddress,
			String subject, String message, String attachFiles)
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

		msg.setFrom(new InternetAddress(userName));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"lan.ta@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"anh.nguyen@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"my.vu@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"caroline.schofield@c-mg.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"elaine.dimon@c-mg.com"));
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		MimeBodyPart attachPart = new MimeBodyPart();
		try {
			attachPart.attachFile(attachFiles);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		// sends the e-mail
		Transport.send(msg, msg.getAllRecipients());
	}

}
