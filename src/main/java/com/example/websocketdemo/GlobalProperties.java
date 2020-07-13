package com.example.websocketdemo;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class GlobalProperties {
	private HashMap<String, String> transactionSessionMap = new HashMap<String, String>();
	private HashMap<String, String> sessionTransactionMap = new HashMap<String, String>();

	public void addTransactionAndSession(String sessionId, String transactionId) {
		this.sessionTransactionMap.put(sessionId, transactionId);
		this.transactionSessionMap.put(transactionId, sessionId);
	}

	public void removeTransactionAndSession(String sessionId) {
		String transactionId = sessionTransactionMap.get(sessionId);
		this.sessionTransactionMap.remove(sessionId);
		this.transactionSessionMap.remove(transactionId);
	}

	public String GetSessionId(String transactionId) {
		return this.transactionSessionMap.get(transactionId);
	}
}
