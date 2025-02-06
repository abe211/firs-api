package com.trainibit.firs_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FirsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirsApiApplication.class, args);
	}

}
