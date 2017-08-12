package com.bytebistro.weatherservice;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class WeatherAlerter {

    public static void emailer(String to, String body, String subject)
    {
        String from = "cst438weather@gmail.com";
        String username = "cst438weather@gmail.com";
        String password = "Ccx63$2DH";
        String host = "localhost";
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");


        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }});

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Sent...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}