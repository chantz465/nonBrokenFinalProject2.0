
package nonbrokenfinalproject2.pkg0;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class NonBrokenFinalProject20 {

   
    public static void main(String[] args) {
        String[] descriptions = {"1967 Ford Mustang", "1922 Ford Model T", "2008 Lincoln Continental", "2002 Lexus",
		"2007 BMW", "1910 Mercer Runabout", "2009 Mercedes Benz ", "1930 Cadillac V-16 "}; // array car names
		double[] dailyFees = {65, 95, 135, 140, 160, 165, 200, 205}; // array fees
		char[] carCodes = {'A', 'A', 'L', 'L', 'L', 'A', 'L', 'A'}; // array car codes
		boolean[] availableIndicators = new boolean[8]; // array
		for (int i = 0; i < 8; i++) { // for loop
			availableIndicators[i] = true;
		} // end for
		boolean isOneAvailable = true; // while
		Scanner response = new Scanner(System.in);// scanner
                char carType = ' '; // car type
                boolean isError = false; //error
                String customerName = " "; // customer names
		int numDays = 0; // number of days
                NumberFormat money = NumberFormat.getCurrencyInstance();//new money
                char cancel = ' ';// cancel 
                
                
		while (isOneAvailable) { // while loop
			response = new Scanner(System.in); 
			System.out.println("Please type in your name:"); // ask for name
			customerName = response.nextLine(); // custormer name
			
			
                        do{ // try catch 
                            try { 
                                do{
                                    isError = true;
                                    System.out.println("Would you like an Antique or Luxury car (A/L)?");
                                    carType = response.next().charAt(0);// scanner
                                    carType = Character.toUpperCase(carType);
                        
                    
                   

                                } while(carType != 'A' && carType != 'L' );
                        
                        
                                 } catch(InputMismatchException err){
                        
                        System.out.println("Try again");
                        System.out.println("Please type again");
                        isError = false;
                        response = new Scanner(System.in);
                        
                  
                } // end catch
                }  while(isError == false);
                        
                        
                        
			
			
                        
                        
                        do{ // try catch for how many days
                            try { 
                                do{
                                    isError = true;
                                    response = new Scanner(System.in);
                                    System.out.println("How many days would you like to rent this car for"); // ask for number of days
                                    numDays = response.nextInt();// set it to number of days
                        
                    
                   

                                } while(numDays < .5 );
                        
                        
                            } catch(InputMismatchException err){
                        
                        System.out.println("Try again");
                        isError = false;
                        response = new Scanner(System.in);
                        
                  
                } // end catch
                }  while(isError == false);
                        
                        
                        
                        
                        
			response = new Scanner(System.in);
			double currentFee = fulfillRequest(carType, descriptions, dailyFees, carCodes, availableIndicators); // make the contract
			
			if (currentFee == 0) { // if car is not available
				System.out.println("Unfortunately, that car type isn't available. Here's the cars that are available");
				for (int i = 0; i < 8; i++) {
					if (availableIndicators[i] == false) {
						continue;
					} else { // if car can be rented
						System.out.print(descriptions[i] + "   ");
						System.out.print(money.format(dailyFees[i]) + "   ");
						System.out.println(carCodes[i]);
					}// end else
				} // end for
				
				response = new Scanner(System.in);
                        do{ // try catch to make sure they want to rent out the car 
                            try { 
                                do{
                                    isError = true;
                                    System.out.println("Would you like to rent the other car type? type 'Y' if you do. Type 'N' if you would like to end this transaction");
                                    cancel = response.next().charAt(0);// scanner
                                    cancel = Character.toUpperCase(cancel);
                        
                    
                            

                                } while(cancel != 'Y' && cancel != 'N' );
                       
                        
                            } catch(InputMismatchException err){
                        
                                System.out.println("Try again");
                                
                                isError = false;
                                response = new Scanner(System.in);
                        
                  response = new Scanner(System.in);
                            } // end catch
                            }  while(isError == false);
                                if (cancel == 'N') {
					System.out.println("Thank you for your time. Have a nice day.");
					continue;
				} else { // check to see if other cars are aviable to rent 
					if (carType =='A') {
						carType ='L';
					} else {
						carType = 'A';
					}// end else
				} // end first else
				currentFee = fulfillRequest(carType, descriptions, dailyFees, carCodes, availableIndicators); // make contract
				if (currentFee == 0) {
					System.out.println("There are no more available cars.");
					break;
				}// end if
			} // end big if on 99
                        response = new Scanner(System.in);
			double totalPrice = calculateContractAmount(currentFee, numDays, carType);  // add tax if everthing works out
			int carIndicator = 0;
			for (int i = 0; i < 8; i++) {
				if (dailyFees[i] == currentFee) {
					carIndicator = i;
					break;
				} // end if
			} // end for
			
			System.out.println(customerName);
			System.out.println("Your car: " + descriptions[carIndicator]);
			System.out.println("Total price for " + numDays + " days of rental: " + money.format(totalPrice));
			System.out.println();
			
                        response = new Scanner(System.in);
                        
			int count = 0;
			for (int i = 0; i < 8; i++) {
				if (availableIndicators[i] == false) {
					count++;
				} // end if 
			} // end for
			if (count == 8) {
				System.out.println("There are no more available cars.");
				break;
			} // end if
                        
                        response = new Scanner(System.in);
                        
                        do{
                            try { 
                                do{
                                    isError = true;
                                    System.out.println("Would you like to enter another name (Y/N)");
                                    cancel = response.next().charAt(0);// scanner
                                    cancel = Character.toUpperCase(cancel);
                        
                    
                            

                                } while(cancel != 'Y' && cancel != 'N' );
                       
                        
                            } catch(InputMismatchException err){
                        
                                System.out.println("Try again");
                                
                                isError = false;
                                response = new Scanner(System.in);
                        
                                          response = new Scanner(System.in);

                            } // end catch
                            }  while(isError == false);
                                if (cancel == 'N') {
					System.out.println("Thank you for your time. Have a nice day.");
					isOneAvailable = false;
				} else {
					                        response = new Scanner(System.in);

				}// end else
				
                                /*currentFee = fulfillRequest(carType, descriptions, dailyFees, carCodes, availableIndicators);
				if (currentFee == 0) {
					System.out.println("There are no more available cars.");
					isOneAvailable = false;
				}// end if*/
		} // end while loop
	} // end main
	
	public static double fulfillRequest(char requestedType, String[] des, double[] fees,  char[] codes, boolean[] indicators) {
		boolean foundCar = false;
		int spot = 0;
		for (int i = 0; i < 8; i++) {
			//if (codes[i].equals(requestedType)) {
                        if (codes[i] == requestedType) {
				if (indicators[i] == true) {
					indicators[i] = false;
					foundCar = true;
					spot = i;
					break;
				}
			}
		} // end for
		if (foundCar) {
			return fees[spot];
		} else {
			return 0;
		}// end else
	} // end method
	
	public static double calculateContractAmount(double fee, int days, char type) {
		double beforeTaxTotal = fee * days;
		double tax;
		if (type == 'A') {
			tax = 1.06;
		} else {
			tax = 1.08;
		} // end else
		return beforeTaxTotal * tax;
	} // end method
    
    
}
