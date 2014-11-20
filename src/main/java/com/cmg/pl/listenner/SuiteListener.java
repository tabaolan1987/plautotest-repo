package com.cmg.pl.listenner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import javax.print.attribute.HashAttributeSet;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import testlink.api.java.client.TestLinkAPIException;

import com.c_mg.pl.selenium.PLAUTOTEST.Constant;
import com.c_mg.pl.selenium.PLAUTOTEST.FolderZiper;
import com.c_mg.pl.selenium.PLAUTOTEST.PropertiesHelper;
import com.c_mg.pl.selenium.PLAUTOTEST.TestLinkUtil;

public class SuiteListener implements ISuiteListener {
	
	
	public void onStart(ISuite suite) {
		/*System.out.println("===================="+suite.getName()+"=======================================");
		TestLinkUtil testLink = new TestLinkUtil();
		try {
			testLink.createNewBuild();
			Constant.mapContainer = new HashMap<String, String>();
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		*/
	}

	public void onFinish(ISuite suite) {
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "465";
		String mailFrom = "lan.ta@c-mg.com";
		String password = "19092011";

		// message info
		String mailTo = "lan.ta@c-mg.com,tabaolan1987@gmail.com";
		String subject = "Automation Daily Test Result";
		String message = "<p>Dear all,<p>This is the automation test for PL PROD daily test result.<p>Kind regards,<p>Lan Ta";
		// attachments
		try {
			ArrayList<String> list = new ArrayList<String>();
			String reportZip = ZipFolderReports();
			if (reportZip != null) {
				list.add(reportZip);
			}
			String screenshotsZip = ZipFolderScreenshots();
			if (screenshotsZip != null) {
				String path = PropertiesHelper.getKey("project.basedir")
						+ File.separator + "target" + File.separator
						+ "screenshots";
				long size = FileUtils.sizeOfDirectory(new File(path));
				System.out.println("folder screenshots size : " + size);
				if (size > 0) {
					list.add(screenshotsZip);
				}
			}
			/*
			 * String videoZip = ZipFolderVideo(); if (videoZip != null) {
			 * list.add(videoZip); }
			 */
			String[] attachfiles = new String[list.size()];
			list.toArray(attachfiles);
			//Constant.updateStatusToTestLink();
			sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
					subject, message, attachfiles);
			System.out.println("Email sent.");
			
			
			
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}

	private static String ZipFolderReports() {
		String path = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "target" + File.separator
				+ "surefire-reports";
		String pathZip = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "surefire-reports.zip";
		try {
			File ext = new File(pathZip);
			if (ext.exists()) {
				delete(ext);
			}
			File input = new File(path);
			if (input.exists()) {
				FolderZiper.zipFolder(path, pathZip);
				File zip = new File(pathZip);
				if (zip.exists()) {
					return zip.getAbsolutePath();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String ZipFolderScreenshots() {
		String path = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "target" + File.separator + "screenshots";
		String pathZip = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "screenshots.zip";
		try {
			File ext = new File(pathZip);
			if (ext.exists()) {
				delete(ext);
			}
			File input = new File(path);
			if (input.exists()) {
				FolderZiper.zipFolder(path, pathZip);
				File output = new File(pathZip);
				if (output.exists()) {
					return output.getAbsolutePath();
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	private static String ZipFolderVideo() {
		String path = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "Video";
		String pathZip = PropertiesHelper.getKey("project.basedir")
				+ File.separator + "VideoZip.zip";
		try {
			File ext = new File(pathZip);
			if (ext.exists()) {
				delete(ext);
			}
			File input = new File(path);
			if (input.exists()) {
				FolderZiper.zipFolder(path, pathZip);
				File output = new File(pathZip);
				if (output.exists()) {
					return output.getAbsolutePath();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void delete(File file) throws IOException {
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
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"xuan.bui@c-mg.com"));
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
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				multipart.addBodyPart(attachPart);
			}
		}
		msg.setContent(multipart);
		// sends the e-mail
		Transport.send(msg, msg.getAllRecipients());
	}

}
