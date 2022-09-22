package com.ssafy.penetration.penetration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PenetrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenetrationApplication.class, args);
	}

	// localhost 실행시, index.html로 이동

}
