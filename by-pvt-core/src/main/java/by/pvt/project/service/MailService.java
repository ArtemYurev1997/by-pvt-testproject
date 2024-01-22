package by.pvt.project.service;

import by.pvt.project.contract.MailSenderService;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import jakarta.mail.SendFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService implements MailSenderService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Override
    public void send(UserRequest userRequest) {
        var subject = "Активация учетной записи самого себя";
        var messageBody = "Сообщение доставлено от пользователя с почтой " + userRequest.getEmail();

        var mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(userRequest.getEmail());
        mailMessage.setSubject(subject);
        mailMessage.setText(messageBody);
        javaMailSender.send(mailMessage);
    }
}
