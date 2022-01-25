package com.tiaa.chatbotConfig.repository.chatbotConfig.firebase;

import java.util.concurrent.ExecutionException;

import com.tiaa.chatbotConfig.model.chatbotConfig.ChatbotConfig;

import org.springframework.stereotype.Service;

@Service
public interface FirebaseChatbotConfigRepository {
	public ChatbotConfig set(ChatbotConfig chatbotConfig, String collectionName) throws InterruptedException, ExecutionException;
	public ChatbotConfig getById(String id, String collectionName) throws InterruptedException, ExecutionException;
	public String delete(String id, String collectionName) throws InterruptedException, ExecutionException;
}
