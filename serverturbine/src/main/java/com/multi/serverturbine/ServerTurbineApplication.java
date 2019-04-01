package com.multi.serverturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author lpfei
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
public class ServerTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerTurbineApplication.class, args);
	}

}
