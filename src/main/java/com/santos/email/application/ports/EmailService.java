package com.santos.email.application.ports;

import com.santos.email.application.entities.EmailModel;
import java.util.Optional;
import java.util.UUID;

public interface EmailService {
    EmailModel sendEmail(EmailModel emailModel);
//    Page<EmailModel> findAll(Pageable pageable);
    Optional<EmailModel> findById(UUID emailId);
}