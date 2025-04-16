package com.DatNguyen.AuthService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan("com.DatNguyen.AuthService.Entity")
public class ImageGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImageGeneratorApplication.class, args);
	}
}
