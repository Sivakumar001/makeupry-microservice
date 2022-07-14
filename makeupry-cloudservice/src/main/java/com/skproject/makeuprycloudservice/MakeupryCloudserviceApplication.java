package com.skproject.makeuprycloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MakeupryCloudserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeupryCloudserviceApplication.class, args);
	}

}
