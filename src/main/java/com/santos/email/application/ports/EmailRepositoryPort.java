package com.santos.email.application.ports;

import com.santos.email.application.domain.Email;

import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {
    Email save(Email email);
//    Page<EmailModel> findAll(Pageable pageable);
    Optional<Email> findById(UUID emailId);
}
