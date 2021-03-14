package com.org.ra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 1. serve per mandare messaggi direttamente al topic (senza passare dal controller)
		registry.enableSimpleBroker("/topic");
		
		// 2. serve per poter mandare messaggi al controller dell'applicazi	one
		registry.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// registrazione di un endpoin stomp
		// questo endpoint è quello a cui si connetterà il client per instaurare la connessione con STOMP websocket
		registry.addEndpoint("/my-websocket");
		
		// questo endopoint è uguale a quello di sopra
		// ma serve come fallback nel caso il client non implementa protocollo websocket
		registry.addEndpoint("/my-websocket").withSockJS();
	}

}
