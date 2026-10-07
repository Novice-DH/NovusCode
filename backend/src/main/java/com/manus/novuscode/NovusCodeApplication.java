package com.manus.novuscode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.manus.novuscode.mapper")
public class NovusCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovusCodeApplication.class, args);
	}

}
