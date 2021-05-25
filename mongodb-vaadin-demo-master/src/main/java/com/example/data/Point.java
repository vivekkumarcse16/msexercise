package com.example.data;

import org.springframework.data.annotation.Id;

public class Point {

	@Id
	String name;
	int x;
	int y;

	public Point() {
		//		super();
	}

	public Point(String name, int x, int y) {
		//		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [name=" + name + ", x=" + x + ", y=" + y + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



}
