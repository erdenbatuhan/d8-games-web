package com.d8games.web.services.service;

import com.d8games.web.services.config.ConfigManager;
import com.d8games.web.services.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {

    private static final String SUBJECT = "D8 Games Auth - %s";
    private static final String CONTENT = "%s was generated for %s at %s!";

    public void sendMail(final List<String> recipientList, final String employeeFullName, final String authKey)
            throws IOException, MessagingException {
        final Date now = DateUtil.getCurrentDate();

        final String username = ConfigManager.getGmailUsername();
        final String password = ConfigManager.getGmailPassword();

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(username, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getRecipients(recipientList)));
        msg.setSubject(String.format(SUBJECT, employeeFullName));
        msg.setContent(String.format(CONTENT, authKey, employeeFullName, now), "text/html");
        msg.setSentDate(now);

        Transport.send(msg);
    }

    private String getRecipients(final List<String> recipientList) {
        String recipients = "";

        for (int i = 0; i < recipientList.size(); i++) {
            recipients += recipientList.get(i);

            if (i != recipientList.size() - 1)
                recipients += ",";
        }

        return recipients;
    }
}
