package com.dupradosantini.bookstore.config;

import com.dupradosantini.bookstore.bootstrap.BootstrapData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {


    private  BootstrapData bootstrapData;

    @Autowired
    public TestConfig(BootstrapData bootstrapData) {
        this.bootstrapData = bootstrapData;
    }

    @Bean
    public void dataBaseBootstrap(){
        this.bootstrapData.BootstrapDataInit();
    }
}
