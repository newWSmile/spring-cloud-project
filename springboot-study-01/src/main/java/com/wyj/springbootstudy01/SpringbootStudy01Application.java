package com.wyj.springbootstudy01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
public class SpringbootStudy01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy01Application.class, args);
	}
}
