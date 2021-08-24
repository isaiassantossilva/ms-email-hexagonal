package com.santos.email.adapters.inbound.controllers.email;

import com.santos.email.adapters.inbound.controllers.email.dto.EmailDto;
import com.santos.email.application.entities.EmailModel;
import com.santos.email.application.ports.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public EmailModel sendEmail(@RequestBody EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        return emailService.sendEmail(emailModel);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmailModel> findEmailById(@PathVariable String id){
        var email = emailService.findById(UUID.fromString(id));

        return email.map(emailModel -> ResponseEntity.ok().body(emailModel))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
