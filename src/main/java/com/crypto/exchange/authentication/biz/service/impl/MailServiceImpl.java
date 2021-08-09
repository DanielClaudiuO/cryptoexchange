package com.crypto.exchange.authentication.biz.service.impl;

import com.crypto.exchange.authentication.biz.service.MailContentBuilder;
import com.crypto.exchange.authentication.biz.service.MailService;
import com.crypto.exchange.authentication.exception.EmailFailureException;
import com.crypto.exchange.authentication.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    @Override
    public void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> buildEmail(notificationEmail, mimeMessage);
        try {
            mailSender.send(mimeMessagePreparator);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new EmailFailureException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
    }

    private void buildEmail(NotificationEmail notificationEmail, MimeMessage mimeMessage) throws MessagingException {
        mimeMessage.setContent(mailContentBuilder.build(notificationEmail.getBody(), notificationEmail.getLink()), "text/html");
        var messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("daniel.oanta@email.com");
        messageHelper.setTo(notificationEmail.getRecipient());
        messageHelper.setSubject(notificationEmail.getSubject());
    }
}
