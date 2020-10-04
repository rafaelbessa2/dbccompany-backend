package br.com.dbccompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbccompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbccompanyApplication.class, args);
		SpringApplication.run(ScheduledTasks.class);
	}

}
