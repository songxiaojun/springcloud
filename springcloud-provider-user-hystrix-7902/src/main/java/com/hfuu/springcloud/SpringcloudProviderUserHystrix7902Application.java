package com.hfuu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan("com.hfuu.springcloud.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class SpringcloudProviderUserHystrix7902Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderUserHystrix7902Application.class, args);
	}
}
