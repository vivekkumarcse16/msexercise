package com.example.view;

import java.util.Collection;

import com.example.controller.P2PServiceController;
import com.example.controller.PointController;
import com.example.data.Point;
import com.example.proxy.CreateP2PServiceProxy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("createp2pservice")
public class P2PserviceNewView extends VerticalLayout {
	
	P2PServiceController p2pServiceController;
	public P2PserviceNewView(P2PServiceController p2pServiceController, PointController pointController){

		this.p2pServiceController =p2pServiceController;
		Label serviceLabel= new Label("Create P2P Service");
		TextField serviceName= new TextField("Enter Service Name");
		ComboBox<Point> startPoint = new ComboBox<>();
		startPoint.setLabel("Available Start Points");
		Collection<Point> startPoints = pointController.findAll();
		startPoint.setItems(startPoints);
		ComboBox<Point> endPoint = new ComboBox<>();
		endPoint.setLabel("Available End Points");
		Collection<Point> endPoints = pointController.findAll();
		endPoint.setItems(endPoints);
		HorizontalLayout pointsLayout= new HorizontalLayout(startPoint,endPoint);
		pointsLayout.setDefaultVerticalComponentAlignment(Alignment.END);
		Button button = new Button("Create");
		add(serviceLabel);
		add(serviceName);
		add(pointsLayout);
		add(button);
		setSizeFull();
		button.addClickListener(click->
		new CreateP2PServiceProxy().createP2PService(serviceName.getValue(),startPoint.getValue(),
				endPoint.getValue(), p2pServiceController,this));
	}

}
