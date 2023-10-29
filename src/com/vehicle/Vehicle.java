package com.vehicle;
import com.color_enum.Color;
import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle> {
	
	private String chasisNo;
	private int id;
	private Color color;
	private double price;
	private LocalDate manufacturerDate;
	private String Company;
	private boolean isAvailable; 
	
	public static int idCount;

	static {
		idCount=1001;
	}
	
	
	public Vehicle(String chasisNo, String color, double price, LocalDate manufacturerDate, String company,
			boolean isAvailable) {
		super();
		idCount++;
		this.chasisNo = chasisNo;
		this.id = idCount;
		this.color = Color.valueOf(color);
		this.price = price;
		this.manufacturerDate = manufacturerDate;
		Company = company;
		this.isAvailable = isAvailable;
	}
	
	public Vehicle(String chasisNo) {
		super();
		this.chasisNo=chasisNo;
	}
	
	
	public String getChasisNo() {
		return chasisNo;
	}

	public Color getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getManufacturerDate() {
		return manufacturerDate;
	}

	public String getCompany() {
		return Company;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public static int getIdCount() {
		return idCount;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", id=" + id + ", color=" + color + ", Price=" + price
				+ ", manufacturerDate=" + manufacturerDate + ", Company=" + Company + ", isAvailable=" + isAvailable
				+ "]";
	}


	@Override
	public boolean equals(Object o) {
		System.out.println("In Vehicle Equals");
		if(o instanceof Vehicle) {
			Vehicle v=(Vehicle)o;
			return this.chasisNo.equals(v.chasisNo);
		}
		return false;
	}
	
	@Override
	public int compareTo(Vehicle anotherVehicle) {
		System.out.println("In compareTo");
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}
	
}
