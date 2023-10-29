package com.color_enum;

public enum Color {
	black(10000),white(5000),silver(8000),blue(15000),gray(75000);
	
	private double additionalPrice;
	private Color(double additionalPrice) {
		this.additionalPrice=additionalPrice;
	}
	public double getPrice() {
		return additionalPrice;
	}
	
	@Override
	public String toString() {
		return name();
	}
	
}
