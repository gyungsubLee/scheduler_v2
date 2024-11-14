package com.example.scheduler_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchedulerV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerV2Application.class, args);
    }

}
