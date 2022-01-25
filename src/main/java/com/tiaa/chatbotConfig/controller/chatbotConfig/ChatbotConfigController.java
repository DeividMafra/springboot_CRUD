package com.tiaa.chatbotConfig.controller.chatbotConfig;

import java.util.concurrent.ExecutionException;

import com.tiaa.chatbotConfig.model.chatbotConfig.ChatbotConfig;
import com.tiaa.chatbotConfig.service.chatbotConfig.ChatbotConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatbotConfigController {
	
	@Autowired
	ChatbotConfigService chatbotConfigService;

	// http://localhost:8080/getChatbotConfig?client_id=1234
	@PostMapping("/saveChatbotConfig")
	public ChatbotConfig saveChatbotConfig(@RequestBody ChatbotConfig chatbotConfig) throws InterruptedException, ExecutionException{
		return chatbotConfigService.setConfig(chatbotConfig);
	}

	// http://localhost:8080/saveChatbotConfig
	// HEADER: Content-Type:application/json
	@GetMapping("/getChatbotConfig")
	public ChatbotConfig getChatbotConfig(@RequestParam String client_id) throws InterruptedException, ExecutionException{
		return chatbotConfigService.getConfigById(client_id);
	}

	// http://localhost:8080/deleteChatbotConfig?client_id=5678
	@DeleteMapping("/deleteChatbotConfig")
	public String deleteChatbotConfig(@RequestParam String client_id) throws InterruptedException, ExecutionException{
		return chatbotConfigService.deleteConfigById(client_id);
	}
	
}
