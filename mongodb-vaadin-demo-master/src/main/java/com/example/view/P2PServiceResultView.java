package com.example.view;

import com.example.controller.P2PServiceController;
import com.example.controller.PointController;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("p2pserviceresultview")
public class P2PServiceResultView extends VerticalLayout {

	public P2PServiceResultView(){
	
		Label serviceResultLabel= new Label("P2P Service created");
		add(serviceResultLabel);
		setSizeFull();
	}
}
