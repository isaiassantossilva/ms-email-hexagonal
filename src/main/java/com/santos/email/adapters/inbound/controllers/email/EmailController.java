package com.santos.email.adapters.inbound.controllers.email;

import com.santos.email.adapters.inbound.controllers.email.dto.EmailDto;
import com.santos.email.application.domain.Email;
import com.santos.email.application.ports.EmailServicePort;
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

    private final EmailServicePort emailServicePort;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public Email sendEmail(@RequestBody EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        return emailServicePort.sendEmail(email);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Email> findEmailById(@PathVariable String id){
        var email = emailServicePort.findById(UUID.fromString(id));

        return email.map(emailModel -> ResponseEntity.ok().body(emailModel))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
