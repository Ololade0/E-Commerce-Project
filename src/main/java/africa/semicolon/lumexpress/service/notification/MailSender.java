package africa.semicolon.lumexpress.service.notification;

public interface MailSender {
    String sendHtmlMail(EmailDetails emailDetails);
}
