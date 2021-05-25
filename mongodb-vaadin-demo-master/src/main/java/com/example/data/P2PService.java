package com.example.data;

import java.util.List;

import org.springframework.data.annotation.Id;


public class P2PService {

	@Id
	String name;
	Long   serviceId;
    List <Point> points;


	public P2PService() {

	}


	public P2PService(String name, Long serviceId, List<Point> points) {
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
		return "P2PService [name=" + name + ", serviceId=" + serviceId + ", points=" + points + "]";
	}


}
