package com.example.websocketdemo;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;

@Component
public class RabbitMQReceiver {
	@Autowired
	private NotificationService notificationService;

	@Autowired
	public GlobalProperties globalProperties;
	
	private ObjectMapper mapper = new ObjectMapper();

	@RabbitListener(queues = "long_running_process_progress_status")
	public void receive(@Payload String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
			throws IOException {
		try {
			Notification notification = mapper.readValue(message, Notification.class);
			String sessionId = globalProperties.GetSessionId(notification.getTransactionId());
			if (sessionId != null) {
				notificationService.notify(notification.getMessage(), sessionId);
			}
		} catch (Exception ex) {
		}
		
		channel.basicAck(tag, false);
	}
}
