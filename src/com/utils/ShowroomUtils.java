package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exceptions.InvalidInputException;
import com.vehicle.Vehicle;

public class ShowroomUtils {
	public static Vehicle findByChasisNo(String chNo, List<Vehicle> list) throws InvalidInputException {
		Vehicle vehicle = new Vehicle(chNo);
		int index = list.indexOf(vehicle);
		if (index == -1)
			throw new InvalidInputException("Invalid ch no , Vehicle not found !!!!");
//		System.out.println(list.get(index));
		return vehicle;
	}

	// add a static method to return a populate list of vehicles , with sample data
	public static List<Vehicle> populateShowroom() {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("abc-1233", "black",456789,LocalDate.parse("2023-05-25"), "Honda", true));
		vehicles.add(new Vehicle("abc-1235", "white", 556787, LocalDate.parse("2022-10-20"), "Maruti", true));
		vehicles.add(new Vehicle("abc-1238", "silver", 956789, LocalDate.parse("2023-05-25"), "Mahindra",true));
		vehicles.add(new Vehicle("abc-1239", "black", 576787, LocalDate.parse("2023-10-21"), "Honda",true));
		vehicles.add(new Vehicle("abc-1231", "blue", 496789, LocalDate.parse("2022-08-20"), "Honda",true));
		vehicles.add(new Vehicle("abc-1234", "gray", 706787, LocalDate.parse("2023-05-25"), "Tata",true));
		vehicles.add(new Vehicle("abc-1230", "silver", 416789, LocalDate.parse("2022-08-20"), "Honda",true));
		vehicles.add(new Vehicle("abc-1236", "blue", 356787, LocalDate.parse("2023-05-25"), "Tata",true));
	
		return vehicles;
	}
}
