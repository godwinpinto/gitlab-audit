package com.gp.gdd;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
/**
 * Spring boot starter class
 */
public class GddApplication {
	public static void main(String[] args) {
		SpringApplication.run(GddApplication.class, args);
	}
}
