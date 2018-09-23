package com.hfuu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@MapperScan("com.hfuu.springcloud.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudProviderUserHystrix7902Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderUserHystrix7902Application.class, args);
	}
}
