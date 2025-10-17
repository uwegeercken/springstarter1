package com.datamelt.springstarter;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ApplicationConfiguration.class)
@SpringBootApplication
public class SpringstarterApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringstarterApplication.class, args);
	}

}
