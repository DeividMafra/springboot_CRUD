package com.tiaa.chatbotConfig.model.chatbotConfig;

import org.springframework.data.redis.core.RedisHash;

// @RedisHash("ChatbotConfig")
public class ChatbotConfig {

	private boolean client_enabled;
	private String client_id;
	private boolean employer_enabled;
	private String employer_id;
	private boolean location_enabled;
	private String location_id;
	private boolean plan_enabled;
	private String plan_id;

	public boolean isClient_enabled() {
		return client_enabled;
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public boolean isPlan_enabled() {
		return plan_enabled;
	}
	public void setPlan_enabled(boolean plan_enabled) {
		this.plan_enabled = plan_enabled;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public boolean isLocation_enabled() {
		return location_enabled;
	}
	public void setLocation_enabled(boolean location_enabled) {
		this.location_enabled = location_enabled;
	}
	public String getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(String employer_id) {
		this.employer_id = employer_id;
	}
	public boolean isEmployer_enabled() {
		return employer_enabled;
	}
	public void setEmployer_enabled(boolean employer_enabled) {
		this.employer_enabled = employer_enabled;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public void setClient_enabled(boolean client_enabled) {
		this.client_enabled = client_enabled;
	}
	
}
