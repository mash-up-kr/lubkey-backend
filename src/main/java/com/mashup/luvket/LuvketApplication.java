package com.mashup.luvket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LuvketApplication {
/*

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "classpath:aws.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(LuvketApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(LuvketApplication.class, args);
	}

}
