package com.example.websocketdemo;

public class Notification {

	private String message;
    private String transactionId;
    
	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setMessage(String content) {
		this.message = content;
	}

	public String getMessage() {
		return this.message;
	}

}