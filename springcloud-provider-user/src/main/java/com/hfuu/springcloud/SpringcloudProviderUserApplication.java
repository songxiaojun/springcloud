package com.hfuu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderUserApplication.class, args);
	}
}
