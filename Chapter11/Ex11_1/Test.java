// Author: Travis Dowd
// Date: 5-1-2020
//
// Chapter 11, exercise 11-1


package Ex11_1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// Get user input for variables
		try( Scanner input = new Scanner( System.in )){
			System.out.println( "Let's make a triangle. ");
			// Sides
			System.out.print( "Side 1: ");
			double Side1 = input.nextDouble();
			System.out.print( "Side 2: ");
			double Side2 = input.nextDouble();
			System.out.print( "Side 3: ");
			double Side3 = input.nextDouble();
			// Color & filled
			System.out.print( "Color: ");
			String Color = input.next();
			System.out.print( "Filled: ");
			boolean Filled = input.nextBoolean();
			// Create Triangle object
			Triangle triangle = new Triangle( Side1, Side2, Side3);
			triangle.setColor( Color );
			triangle.setFilled( Filled );
			// Print out object's information
			System.out.println( "Area: " + triangle.getArea());
			System.out.println( "Perimeter: " + triangle.getPerimeter());
			System.out.println( triangle.toString());
		}
	}

}
