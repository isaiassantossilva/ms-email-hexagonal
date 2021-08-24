package com.santos.email.adapters.outbound.persistence;

import com.santos.email.adapters.outbound.persistence.entities.EmailEntity;
import com.santos.email.application.domain.Email;
import com.santos.email.application.ports.EmailRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
@RequiredArgsConstructor
public class FakeEmailRepositoryPort implements EmailRepositoryPort {

    private static final Map<UUID, EmailEntity> db = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(FakeEmailRepositoryPort.class);
    private final ModelMapper modelMapper;

    @Override
    public Email save(Email email) {
        var emailEntity = modelMapper.map(email, EmailEntity.class);

        emailEntity.setEmailId(UUID.randomUUID());
        emailEntity.setSendDateEmail(LocalDateTime.now());

        db.put(emailEntity.getEmailId(), emailEntity);

        log.info("Email saved");

        return modelMapper.map(emailEntity, Email.class);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        log.info("Finding email by id");
        var emailEntity = db.get(emailId);
        var email = modelMapper.map(emailEntity, Email.class);
        return Optional.ofNullable(email);
    }
}
