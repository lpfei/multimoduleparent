package com.multi.serverconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lpfei
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ServerConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerConfigClientApplication.class, args);
	}

}
