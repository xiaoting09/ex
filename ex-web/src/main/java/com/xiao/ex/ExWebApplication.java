package com.xiao.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ExWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExWebApplication.class, args);
	}
}
