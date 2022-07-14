package com.skproject.makeupryproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MakeupryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeupryProductApplication.class, args);
	}
}
