package com.createP2pService.createP2pServiceSimulator.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.createP2pService.createP2pServiceSimulator.config.MessagingConfig;
import com.createP2pService.createP2pServiceSimulator.data.P2PServiceRequest;
import com.createP2pService.createP2pServiceSimulator.data.P2PServiceResult;


@RestController
public class CreateP2PServiceController {

	   @Autowired
	    private RabbitTemplate template;
	
	@PostMapping(path="/createp2pservice")
	public P2PServiceResult createService(@RequestBody P2PServiceRequest requestBody){
		
		P2PServiceResult result= new P2PServiceResult();
		result.setName(requestBody.getServiceName());
		result.setPoints(requestBody.getPoints());
		//generates randomly
		result.setServiceId((long)((float)Math.random()*100));
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, result);
		return result;
		
	}

}
