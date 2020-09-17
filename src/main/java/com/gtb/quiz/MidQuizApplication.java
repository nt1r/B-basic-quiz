package com.gtb.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// GTB: - 在 CLI 里无法通过 gradle 构建
@SpringBootApplication
public class MidQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidQuizApplication.class, args);
	}

}
