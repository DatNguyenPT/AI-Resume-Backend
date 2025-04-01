package com.DatNguyen.Resume_Builder_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication(exclude = {
		org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration.class
})
@EnableReactiveMongoRepositories(basePackages = "com.DatNguyen.Resume_Builder_Service.Repository")
public class ResumeBuilderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderServiceApplication.class, args);
	}

}
