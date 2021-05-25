package com.example.controller;

import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;
import com.example.data.P2PService;
import com.example.repository.P2PServiceRepository;


@Repository
public class P2PServiceController  implements CrudListener<P2PService> {


	private final P2PServiceRepository repository;

	public P2PServiceController(P2PServiceRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<P2PService> findAll() {
		return repository.findAll();
	}

	@Override
	public P2PService add(P2PService p2pService) {
		return repository.insert(p2pService);
	}

	@Override
	public P2PService update(P2PService p2pService) {
		return repository.save(p2pService);
	}

	@Override
	public void delete(P2PService p2pService) {
		repository.delete(p2pService);
	}


}
