package com.santos.email.application.domain;

import com.santos.email.application.domain.enums.StatusEmail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Email {

    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
