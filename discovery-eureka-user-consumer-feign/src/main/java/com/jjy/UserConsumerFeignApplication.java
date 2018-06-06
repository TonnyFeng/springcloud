package com.jjy;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@EnableFeignClients
public class UserConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerFeignApplication.class, args);
	}
}
