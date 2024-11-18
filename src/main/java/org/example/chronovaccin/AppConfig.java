package org.example.chronovaccin;

//import jakarta.persistence.EntityManagerFactory;
//import org.example.chronovaccin.repository.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
