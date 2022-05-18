package com.dupradosantini.bookstore.config;

import com.dupradosantini.bookstore.bootstrap.BootstrapData;
import com.dupradosantini.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private BootstrapData bootstrapData;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean dataBaseCreation(){
        if(strategy.equals("create-drop")){
            this.bootstrapData.BootstrapDataInit();
        }
        return false;
    }
}
