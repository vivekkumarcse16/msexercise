package com.example.view;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.controller.P2PServiceController;
import com.example.data.P2PService;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("p2pservicelistView")
public class P2PServiceCrudView extends VerticalLayout {


	public P2PServiceCrudView(P2PServiceController p2pServiceController) {

		Label p2pServiceLabel= new Label("P2P Service List : Add/ Edit/ Delete/ Refresh");
		GridCrud<P2PService> crud = new GridCrud<>(P2PService.class, p2pServiceController);
		add(p2pServiceLabel);
		add(crud);
		setSizeFull();
	}
}
