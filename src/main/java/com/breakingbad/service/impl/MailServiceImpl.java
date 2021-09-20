package com.breakingbad.service.impl;

import com.breakingbad.dto.response.NotificationEmail;
import com.breakingbad.exception.MailNotFoundException;
import com.breakingbad.exception.RecordNotFoundException;
import com.breakingbad.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Override
    @Async
    public void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessage.setContent(messageHelper, "message");
            messageHelper.setFrom("breakingbad@email.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Activation mail sent!!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new MailNotFoundException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
    }
}
