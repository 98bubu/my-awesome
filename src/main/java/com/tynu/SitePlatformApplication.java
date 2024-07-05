package com.tynu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tynu.mapper")
public class SitePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitePlatformApplication.class, args);
	}

}
