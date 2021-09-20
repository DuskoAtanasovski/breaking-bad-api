package com.breakingbad.service;

import com.breakingbad.dto.response.NotificationEmail;

public interface MailService {

    void sendMail(NotificationEmail notificationEmail);
}
