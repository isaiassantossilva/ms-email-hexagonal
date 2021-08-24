package com.santos.email.adapters.outbound.smtp;

import com.santos.email.application.domain.Email;
import com.santos.email.application.ports.SendEmailServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SmtpSendEmailService implements SendEmailServicePort {

    private static final Logger log = LoggerFactory.getLogger(SmtpSendEmailService.class);

    @Override
    public void sendEmailSmtp(Email email) {
        log.info("Send email from "+ email.getEmailFrom() +" to "+ email.getEmailTo());
    }
}
