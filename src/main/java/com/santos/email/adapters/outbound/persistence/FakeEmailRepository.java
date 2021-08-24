package com.santos.email.adapters.outbound.persistence;

import com.santos.email.application.entities.EmailModel;
import com.santos.email.application.ports.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
public class FakeEmailRepository implements EmailRepository {

    private static final Map<UUID, EmailModel> db = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(FakeEmailRepository.class);

    @Override
    public EmailModel save(EmailModel emailModel) {

        emailModel.setEmailId(UUID.randomUUID());
        emailModel.setSendDateEmail(LocalDateTime.now());

        db.put(emailModel.getEmailId(), emailModel);
        log.info("Email saved");
        return emailModel;
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        log.info("Finding email by id");
        return Optional.ofNullable(db.get(emailId));
    }
}
