package africa.semicolon.lumexpress.service.notification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
@Slf4j
public class GmailEmailSenderImpl implements MailSender{
    private JavaMailSender javaMailSender;
    @Override
    public String sendHtmlMail(EmailDetails emailDetails) {
      MimeMessage mimeMessage =   javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try{
            mimeMessageHelper.setFrom("no-reply@email.lumExpress.com.ng");
            mimeMessageHelper.setTo(emailDetails.getUserEmail());
            mimeMessageHelper.setText(emailDetails.getMailContent(), true);
            javaMailSender.send(mimeMessage);
            return String.format("email sent to %s successfully", emailDetails.getUserDetails());
        } catch (MessagingException e) {
           e.printStackTrace();
        }
        return String.format("email not sent to %s", emailDetails.getUserEmail());
    }
}
