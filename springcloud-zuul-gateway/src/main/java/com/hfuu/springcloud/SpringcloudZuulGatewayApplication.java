package com.hfuu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringcloudZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulGatewayApplication.class, args);
	}
}
