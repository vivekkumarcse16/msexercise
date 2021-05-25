package com.example.data;

import java.util.List;

public class P2PServiceRequest {

	String serviceName;
	List <Point> points;

	public P2PServiceRequest() {

	}

	public P2PServiceRequest(String serviceName, List<Point> points) {
		super();
		this.serviceName = serviceName;
		this.points = points;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "P2PServiceRequest [serviceName=" + serviceName + ", points=" + points + "]";
	}


}
