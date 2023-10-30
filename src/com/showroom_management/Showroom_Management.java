package com.showroom_management;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vehicle.ParseAndValidateDate;
import com.vehicle.ValidateColour;
import com.vehicle.Vehicle;
import com.color_enum.Color;
import com.custom_ordering.VehiclePriceComparator;
import com.exceptions.InvalidInputException;
import com.utils.ShowroomUtils;

public class Showroom_Management {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			
			int ch=1;
			List<Vehicle> vehArr=ShowroomUtils.populateShowroom();
			
			while(ch!=0) {
				System.out.println("Options : 1 . Add a Vehicle\n" + "2. Display all \n" + "3. Get Vehicle Details\n "
						+ "4. Apply discount\n " + "5. Apply discount on old vehicles\n "
						+ "6. Remove specific vehicle \n 7. Remove vehicles by color \n "
						+ "8. Sort vehicles as per ch no \n 9. Sort vehicle details as per price\n"
						+ "10. Sort vehicle details as per Date n price\n 0.Exit");
				System.out.print("Choose option :");
				ch=sc.nextInt();
				
				try {
				switch(ch) {
				case 1:
					System.out.println("Adding Vehicle...");
					System.out.println("\nEnter chasisNo, color, basePrice, manufacturerDate(yyyy-mm-dd), company, isAvailable");
					vehArr.add(new Vehicle(sc.next(), ValidateColour.validateCol(sc.next().toLowerCase()), sc.nextDouble(), ParseAndValidateDate.validateMd(sc.next()), sc.next(), sc.nextBoolean()));
					
					break;
				case 2:
					System.out.println("Showroom details...");
					for(Vehicle a:vehArr) {
						System.out.println(a);
					}
					break;
				case 3:
					System.out.println("Get Vehicle Details...");
					System.out.println("Enter chasis no. :");
					System.out.println(ShowroomUtils.findByChasisNo(sc.next(),vehArr));
					break;
				case 4:
					System.out.println("Enter chasis no and discount");
					Vehicle vehicle = ShowroomUtils.findByChasisNo(sc.next(), vehArr);
					vehicle.setPrice(vehicle.getPrice()-sc.nextDouble());
					break;
				case 5:
					System.out.println("Enter date and discount");
					LocalDate date=LocalDate.parse(sc.next());
					double discount=sc.nextDouble();
					for(Vehicle v: vehArr)
						if(v.getManufacturerDate().isBefore(date))
							v.setPrice(v.getPrice()-discount);
					System.out.println("Applied Discount.....");
					break;
				case 6:
					System.out.println("Enter chNo");
					boolean removed = vehArr.remove(new Vehicle(sc.next()));
					if(!removed)
						throw new InvalidInputException("Invalid Chasis No.");
					System.out.println("Vehicle Details Removed...");
					break;
				case 7:
					System.out.println("Enter Color");
					Color c=Color.valueOf(ValidateColour.validateCol(sc.next().toLowerCase()));
					Iterator<Vehicle> vehicleItr=vehArr.iterator();
					while(vehicleItr.hasNext()) {
						if(vehicleItr.next().getColor()==c)
							vehicleItr.remove();
					}
					break;
				case 8:
					Collections.sort(vehArr);
					break;
				case 9:
					Collections.sort(vehArr, new VehiclePriceComparator());
					break;
				case 10:
					Collections.sort(vehArr, new Comparator<Vehicle>() {
						@Override
						public int compare(Vehicle o1, Vehicle o2) {
							System.out.println("in compare : date n price");
							int ret = o1.getManufacturerDate().compareTo(o2.getManufacturerDate());
							if(ret == 0)
							{
								if(o1.getPrice()<o2.getPrice())
									return -1;
								if(o1.getPrice()==o2.getPrice())
									return 0;
								return 1;									
							}
							return ret;
						}

					});
					break;
				case 0:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Enter Correct Choice....");
					break;
				}
				
				} catch (Exception e) {
					sc.hasNextLine();
					System.out.println(e);
				}
			}
		}
	}

}