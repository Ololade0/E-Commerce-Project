package africa.semicolon.lumexpress.service.notification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GmailEmailSenderImplTest {
    @Autowired
    private MailSender mailSender;

    @Test
    void sendHtmlMail() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setUserEmail("adesuyiololade@gmail.com");
        emailDetails.setMailContent("Hello Asake");
        String response = mailSender.sendHtmlMail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();
    }
}