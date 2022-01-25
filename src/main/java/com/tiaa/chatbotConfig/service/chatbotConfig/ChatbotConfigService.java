package com.tiaa.chatbotConfig.service.chatbotConfig;

import java.util.concurrent.ExecutionException;

import com.tiaa.chatbotConfig.model.chatbotConfig.ChatbotConfig;

import org.springframework.stereotype.Service;

@Service
public interface ChatbotConfigService {
	public ChatbotConfig setConfig(ChatbotConfig chatbotConfig) throws InterruptedException, ExecutionException;
	public ChatbotConfig getConfigById(String client_id) throws InterruptedException, ExecutionException;
	public String deleteConfigById(String client_id) throws InterruptedException, ExecutionException;
}
