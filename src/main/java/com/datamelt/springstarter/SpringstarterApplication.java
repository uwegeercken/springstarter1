package com.datamelt.springstarter;

import com.datamelt.springstarter.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@EnableConfigurationProperties(ApplicationConfiguration.class)
@SpringBootApplication
public class SpringstarterApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringstarterApplication.class);

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(SpringstarterApplication.class, args);
		ApplicationConfiguration config = context.getBean(ApplicationConfiguration.class);

		logger.info("welcome to: {}", config.getName() + " " + config.getVersion() + ", last updated: " + config.getDate());

	}

}
