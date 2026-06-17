package com.citt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class SpringbootApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiRestApplication.class, args);
	}
}
