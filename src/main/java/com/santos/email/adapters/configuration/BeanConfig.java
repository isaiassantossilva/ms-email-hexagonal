package com.santos.email.adapters.configuration;

import com.santos.email.application.ports.EmailRepositoryPort;
import com.santos.email.application.ports.SendEmailServicePort;
import com.santos.email.application.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort emailRepositoryPort, SendEmailServicePort sendEmailServicePort){
        return new EmailServiceImpl(emailRepositoryPort, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
