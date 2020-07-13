package com.example.websocketdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	private GlobalProperties globalProperties;
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	private Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/notifications")
	public String notifications() {
		return "notifications";
	}

	@RequestMapping("/")
	public String home() {
		return "notifications";
	}

	@MessageMapping("/register")
	public void processMessageFromClient(@Payload Message message, SimpMessageHeaderAccessor headerAccessor)
			throws Exception {
		// logger.info("sessionID" + message);
		logger.info("sessionID" + message.getSessionId());
		globalProperties.addTransactionAndSession(message.getSessionId(), message.getTransactionId());
	}

	@MessageMapping("/unregister")
	public void unregister(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		// logger.info("sessionID" + message);
		logger.info("sessionID" + message.getSessionId());
		globalProperties.removeTransactionAndSession(message.getSessionId());
	}
}
