package com.example.mySqlDatabase;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class MySqlDatabaseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MySqlDatabaseApplication.class, args);
		log.info("MySqlDatabaseApplication app started in {} Environment",context.getEnvironment().getProperty("environment"));
	}

}
