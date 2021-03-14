package com.org.ra.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.org.ra.model.Messaggio;

@Controller
public class MessaggioController {

	@MessageMapping("/messaggio")
	@SendTo("/topic/messaggi")
	public Messaggio greeting(Messaggio messaggio) throws Exception {
		Thread.sleep(1000); // simulated delay
		
	    return new Messaggio("Hello, " + HtmlUtils.htmlEscape(messaggio.getBody()) + "!");
	}
}
