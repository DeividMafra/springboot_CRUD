package com.tiaa.chatbotConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
// @DependsOn("jedisConnectionFactory")
public class ChatbotConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotConfigApplication.class, args);
	}

}
