package com.chatwindow.ChatWindow.websocketconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer   {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websockethandler").setAllowedOriginPatterns("*");
		registry.addEndpoint("/websockethandler").setAllowedOriginPatterns("*")
												 .withSockJS();
	}
	
	@Override
	public void configureMessageBroker(final MessageBrokerRegistry config) {
		// Use this to get a response back from server
	    config.enableSimpleBroker("/chatwithbots");
	    // Use this as prefix in your client to send a message to server
	    config.setApplicationDestinationPrefixes("/sendMessage");
	}

}
