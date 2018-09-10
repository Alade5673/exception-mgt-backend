package com.introspec.ticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableConfigurationProperties
@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = { "com.introspec.ticketing.entity" })
public class TicketingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingAppApplication.class, args);
	}
}
