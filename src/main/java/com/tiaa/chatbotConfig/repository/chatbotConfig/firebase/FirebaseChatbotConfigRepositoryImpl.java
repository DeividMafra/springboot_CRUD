package com.tiaa.chatbotConfig.repository.chatbotConfig.firebase;

import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.tiaa.chatbotConfig.model.chatbotConfig.ChatbotConfig;

import org.springframework.stereotype.Service;

@Service
public class FirebaseChatbotConfigRepositoryImpl implements FirebaseChatbotConfigRepository  {
	
	// private static final String COLLECTION_NAME = "chatbot_config";

	@PostConstruct
	private void initDb(){
		try {
			FileInputStream serviceAccount = new FileInputStream("./chabotConfigServiceKey.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
																		.setCredentials(GoogleCredentials.fromStream(serviceAccount))
																		.setDatabaseUrl("${firebase.host}")
																		.build();
			
			FirebaseApp.initializeApp(options);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ChatbotConfig set(ChatbotConfig chatbotConfig, String collectionName) throws InterruptedException, ExecutionException{
	
		Firestore db = FirestoreClient.getFirestore();

		// try {
		// 	db.collection(COLLECTION_NAME).document(chatbotConfig.getClient_id()).set(chatbotConfig);
		// 	return chatbotConfig;
		// } catch (Exception e) {
		// 	return null;
		// }		

		// ApiFuture<WriteResult> collection = db.collection(COLLECTION_NAME).document(chatbotConfig.getClient_id()).set(chatbotConfig);
		ApiFuture<WriteResult> collection = db.collection(collectionName).document(chatbotConfig.getClient_id()).set(chatbotConfig);
		if (collection != null) {
			return chatbotConfig;
		} else {
			return null;
		}

		// ApiFuture<WriteResult> collection = db.collection(COLLECTION_NAME).document(chatbotConfig.getClient_id()).set(chatbotConfig);
		// return collection.get().getUpdateTime().toString();

	}

	@Override
	public ChatbotConfig getById(String id, String collectionName) throws InterruptedException, ExecutionException {
	
		Firestore db = FirestoreClient.getFirestore();
		// DocumentReference docRef = db.collection(COLLECTION_NAME).document(id);
		DocumentReference docRef = db.collection(collectionName).document(id);

		ApiFuture<DocumentSnapshot> docSnap = docRef.get();
		DocumentSnapshot document = docSnap.get();

		if (document.exists()) {
			ChatbotConfig chatbotConfig = document.toObject(ChatbotConfig.class);
			return chatbotConfig;
		} else {
			return null;
		}

	}

	@Override
	public String delete(String id, String collectionName) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		db.collection(collectionName).document(id).delete();
		return "Id " +id+ " has been deleted!";
	}
	
}