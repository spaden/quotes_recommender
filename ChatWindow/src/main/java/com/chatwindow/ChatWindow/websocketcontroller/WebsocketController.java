package com.chatwindow.ChatWindow.websocketcontroller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
	
	@MessageMapping("/chatwithbots")
	@SendTo("/chatwithbots/botReply")
	public String sendMessage(String userMessage) {
		System.out.println(userMessage);
		return "Testing Bot Reply";
	}
	
}
