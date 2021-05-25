package com.example.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.config.MessagingConfig;
import com.example.controller.P2PServiceController;
import com.example.data.P2PService;
import com.example.data.P2PServiceRequest;
import com.example.data.Point;
import com.example.view.P2PserviceNewView;
import com.vaadin.flow.component.html.Paragraph;

@Component
public class CreateP2PServiceProxy {

	@Autowired
	P2PServiceController p2pServiceController;
	
	public  void createP2PService(String name, Point startPoint, Point endPoint, P2PServiceController p2pServiceController, P2PserviceNewView p2PserviceNewView) {
          
		List <Point> points= new ArrayList<>();
		points.add(startPoint);
		points.add(endPoint);
		P2PServiceRequest p2pServiceRequest = new P2PServiceRequest(name,points);
		ResponseEntity<P2PService> responseEntity= new RestTemplate().
				postForEntity("http://localhost:8100/createp2pservice",
						p2pServiceRequest, P2PService.class);
		P2PService p2pServiceResult= responseEntity.getBody();
		if(p2pServiceResult!=null) {
			p2PserviceNewView.add(new Paragraph("Service created successfully."));
			p2PserviceNewView.add(new Paragraph(""));
			p2PserviceNewView.add(new Paragraph("-------------------------------------------------------------"));
			p2PserviceNewView.add(new Paragraph(p2pServiceRequest.getPoints().get(0).getName()
					+" @___________________________________________@ "
					+p2pServiceRequest.getPoints().get(1).getName()));
			p2PserviceNewView.add(new Paragraph("-------------------------------------------------------------"));
			p2PserviceNewView.add(new Paragraph(""));
			p2PserviceNewView.add(new Paragraph("Service ID: "+p2pServiceResult.getServiceId()));
			p2PserviceNewView.add(new Paragraph("Service Name:  "+p2pServiceRequest.getServiceName()));
			p2PserviceNewView.add(new Paragraph("Service Start Point:  "+p2pServiceRequest.getPoints().get(0)));
			p2PserviceNewView.add(new Paragraph("Service End Point:  "+p2pServiceRequest.getPoints().get(1)));			
		}
	}

	//rabbit mq consumer
	@RabbitListener(queues= MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(P2PService p2pServiceResult)
	{
		//Saved object in DB
		p2pServiceController.add(p2pServiceResult);
		System.out.println("With Vaadin MS: AsyncResponseFromQueue using rabbit mq");
		System.out.println("p2pServiceResult:"+ p2pServiceResult);
	}

}
