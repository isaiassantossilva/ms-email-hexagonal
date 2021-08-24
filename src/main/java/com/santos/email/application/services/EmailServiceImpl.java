package com.santos.email.application.services;

import com.santos.email.application.domain.Email;
import com.santos.email.application.domain.enums.StatusEmail;
import com.santos.email.application.ports.EmailRepositoryPort;
import com.santos.email.application.ports.EmailServicePort;
import com.santos.email.application.ports.SendEmailServicePort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class EmailServiceImpl implements EmailServicePort {

    private final EmailRepositoryPort emailRepositoryPort;
    private final SendEmailServicePort sendEmailServicePort;
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public Email sendEmail(Email email) {
        try {
            sendEmailServicePort.sendEmailSmtp(email);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (Exception e){
            email.setStatusEmail(StatusEmail.ERROR);
            throw new RuntimeException("Not be able send email");
        } finally {
            return emailRepositoryPort.save(email);
        }
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return emailRepositoryPort.findById(emailId);
    }
}
