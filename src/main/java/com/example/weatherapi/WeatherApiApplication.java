package com.example.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class WeatherApiApplication {

	@GetMapping("/version")
	public String getVersion() {
		return "0.1-testing";
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}

}
