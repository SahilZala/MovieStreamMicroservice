package com.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieStreamMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieStreamMicroserviceApplication.class, args);
	}

}
