package org.javaacademy.AtomicStation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Runner.class, args);
		context.getBean(NuclearStation.class).start(3);
	}
}
