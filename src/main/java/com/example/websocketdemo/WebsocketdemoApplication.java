package com.example.websocketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class WebsocketdemoApplication {

	@Bean
	public Queue longRunning_process_progress_statusQueue() {
		return new Queue("long_running_process_progress_status");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebsocketdemoApplication.class, args);
	}

}
