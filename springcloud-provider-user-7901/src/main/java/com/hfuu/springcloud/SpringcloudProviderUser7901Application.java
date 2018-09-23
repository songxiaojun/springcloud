package com.hfuu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@MapperScan("com.hfuu.springcloud.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudProviderUser7901Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderUser7901Application.class, args);
	}
}
