package com.example.view;

import org.vaadin.crudui.crud.impl.GridCrud;
import com.example.controller.PointController;
import com.example.data.Point;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("pointlistview")
public class PointView extends VerticalLayout {

	public PointView(PointController pointController) {

		Label pointLabel= new Label("Point List : Add/ Edit/ Delete/ Refresh");
		GridCrud<Point> crud = new GridCrud<>(Point.class, pointController);
		add(pointLabel);
		add(crud);
		setSizeFull();
	}
}
