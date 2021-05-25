package com.createP2pService.createP2pServiceSimulator.data;

import java.util.List;


public class P2PServiceResult {
	
	String name;
	Long   serviceId;
    List <Point> points;


	public P2PServiceResult() {

	}


	public P2PServiceResult(String name, Long serviceId, List<Point> points) {
		super();
		this.name = name;
		this.serviceId = serviceId;
		this.points = points;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getServiceId() {
		return serviceId;
	}


	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}


	public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "P2PServiceResult [name=" + name + ", serviceId=" + serviceId + ", points=" + points + "]";
	}

}
