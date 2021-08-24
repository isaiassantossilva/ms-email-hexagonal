package com.santos.email.application.services;

import com.santos.email.application.entities.EmailModel;
import com.santos.email.application.entities.enums.StatusEmail;
import com.santos.email.application.ports.EmailRepository;
import com.santos.email.application.ports.EmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public EmailModel sendEmail(EmailModel emailModel) {
        log.info("Sent email from "+ emailModel.getEmailFrom()+" to "+ emailModel.getEmailTo());
        emailModel.setStatusEmail(StatusEmail.SENT);
        return emailRepository.save(emailModel);
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}
