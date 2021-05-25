package com.example.controller;

import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;
import com.example.data.Point;
import com.example.repository.PointRepository;

@Repository
public class PointController  implements CrudListener<Point> {

	private final PointRepository repository;

	public PointController(PointRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<Point> findAll() {
		return repository.findAll();
	}

	@Override
	public Point add(Point point) {
		return repository.insert(point);
	}

	@Override
	public Point update(Point point) {
		return repository.save(point);
	}

	@Override
	public void delete(Point point) {
		repository.delete(point);
	}

}
