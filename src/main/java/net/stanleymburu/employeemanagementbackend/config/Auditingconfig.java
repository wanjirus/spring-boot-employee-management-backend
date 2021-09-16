package net.stanleymburu.employeemanagementbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// enables JPA Auditing

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Auditingconfig{
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareIml();
    }


}
