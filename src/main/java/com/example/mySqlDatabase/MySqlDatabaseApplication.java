package com.example.mySqlDatabase;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MySqlDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlDatabaseApplication.class, args);
		log.info("Employee payroll Application is started");
	}

}
