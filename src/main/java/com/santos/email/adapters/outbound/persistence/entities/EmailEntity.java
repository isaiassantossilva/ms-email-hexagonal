package com.santos.email.adapters.outbound.persistence.entities;

import com.santos.email.application.domain.enums.StatusEmail;
import lombok.Data;

//import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
//@Entity
//@Table(name = "TB_EMAIL")
public class EmailEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
//    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
