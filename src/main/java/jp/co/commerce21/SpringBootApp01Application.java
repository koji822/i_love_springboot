package jp.co.commerce21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootApp01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp01Application.class, args);
	}
}
