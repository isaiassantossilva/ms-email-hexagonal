package com.santos.email.adapters.configuration;

import com.santos.email.application.ports.EmailRepository;
import com.santos.email.application.services.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepository emailRepository){
        return new EmailServiceImpl(emailRepository);
    }

}
