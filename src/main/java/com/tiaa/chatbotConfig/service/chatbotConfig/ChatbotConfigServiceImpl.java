package com.tiaa.chatbotConfig.service.chatbotConfig;

import java.util.concurrent.ExecutionException;

import com.tiaa.chatbotConfig.model.chatbotConfig.ChatbotConfig;
import com.tiaa.chatbotConfig.repository.chatbotConfig.firebase.FirebaseChatbotConfigRepository;
// import com.tiaa.chatbotConfig.repository.chatbotConfig.redis.RedisChatbotConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotConfigServiceImpl implements ChatbotConfigService {

	// FIREBASE REPOSITORY
	@Autowired
	private FirebaseChatbotConfigRepository chatbotConfigRepository;

	// REDIS REPOSITORY - TO-DO
	// @Autowired
	// private RedisChatbotConfigRepository chatbotConfigRepository;

	private static final String COLLECTION_NAME = "chatbot_config";

	@Override
	public ChatbotConfig setConfig(ChatbotConfig chatbotConfig)
			throws InterruptedException, ExecutionException {
		
				try {
					return chatbotConfigRepository.set(chatbotConfig, COLLECTION_NAME);
				} catch (Exception e) {
					return null;
				}

	}

	@Override
	public ChatbotConfig getConfigById(String client_id)
			throws InterruptedException, ExecutionException {
		
				try {
					return chatbotConfigRepository.getById(client_id, COLLECTION_NAME);
				} catch (Exception e) {
					return null;
				}

	}

	@Override
	public String deleteConfigById(String client_id) throws InterruptedException, ExecutionException {

		try {
			return chatbotConfigRepository.delete(client_id, COLLECTION_NAME);
		} catch (Exception e) {
			return null;
		}
	}

}