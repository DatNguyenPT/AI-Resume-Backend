package com.DatNguyen.Resume_Builder_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.DatNguyen.Resume_Builder_Service.Repository")
public class ResumeBuilderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderServiceApplication.class, args);
	}

}
