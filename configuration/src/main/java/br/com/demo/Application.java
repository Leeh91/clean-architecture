package br.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {Application.BASE_PACKAGE})
public class Application {

	static final String BASE_PACKAGE = "br.com.audsat";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
