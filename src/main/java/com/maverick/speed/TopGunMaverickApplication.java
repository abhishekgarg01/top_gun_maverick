package com.maverick.speed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TopGunMaverickApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopGunMaverickApplication.class, args);
	}

}
