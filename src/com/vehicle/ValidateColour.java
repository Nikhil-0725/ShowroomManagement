package com.vehicle;

import com.color_enum.Color;
import com.exceptions.InvalidColorException;

public class ValidateColour {
	public static String validateCol(String col) throws InvalidColorException {
		boolean flag=false;
		for(Color c:Color.values()) {
			if(c.toString().equals(col)) {
				flag=true;
			}
		}
		if(!flag) {
			throw new InvalidColorException("You Entered Invalid Color...");
		} else {
			return col;
		}
	}
}
