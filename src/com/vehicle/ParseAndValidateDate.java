package com.vehicle;
import java.text.ParseException;
import java.time.LocalDate;
import com.exceptions.InvalidManufacturerDate;

public class ParseAndValidateDate {
	public static LocalDate validateMd(String d) throws ParseException,InvalidManufacturerDate {
		LocalDate md1=LocalDate.parse(d);
		String testDate="2021-01-01";
		LocalDate md2=LocalDate.parse(testDate);
		if(md1.isBefore(md2)) {
			throw new InvalidManufacturerDate("Vehicle is too old...");
		} else {
			return md1;
		}
	}
}
