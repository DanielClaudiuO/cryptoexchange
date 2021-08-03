package com.crypto.exchange.authentication.biz.service;

import com.crypto.exchange.authentication.model.NotificationEmail;

public interface MailService {

    void sendMail(NotificationEmail notificationEmail);
}
