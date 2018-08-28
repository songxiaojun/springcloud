package com.hfuu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudDiscoveryEurekaApplication.class, args);
	}
}
