import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
        String to = "test@example.com";
        String from = "from@example.com";

        final String username = "7743ff01fba2a8"; //każdy ma swoje ofc
        final String password = "44791d1c598172"; //same here

        String host = "smtp.mailtrap.io";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("SKJ 2019");
            message.setText("Testowa wiadomość, takie tam wariactwa w Javie napisane...");

            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Nie udało się wysłać wiadmomości");
        } finally {
            System.out.println("Wiadomosc wysłana ;)");
        }
    }
}
