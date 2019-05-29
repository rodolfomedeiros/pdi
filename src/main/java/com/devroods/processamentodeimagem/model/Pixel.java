package com.devroods.processamentodeimagem.model;

public class Pixel {
	
	
	private int valueGray;
	private int x;
	private int y;
	
	public Pixel(int valueGray, int x, int y) {
		this.valueGray = valueGray;
		this.x = x;
		this.y = y;
	}
	public int getValueGray() {
		return valueGray;
	}
	public void setValueGray(int valueGray) {
		this.valueGray = valueGray;
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
