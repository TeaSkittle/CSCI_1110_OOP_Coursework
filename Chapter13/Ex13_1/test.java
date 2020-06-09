// (c) Travis Dowd
// (d) 6-9-2020
//
// Chapter 13, exercise 13-1

package Ex13_1;

import java.util.Scanner;

class test {
	public static void main( String[] args ) {
		try ( Scanner input = new Scanner( System.in)) {
			System.out.print( "Side 1: " );
			double side1 = input.nextDouble();
			System.out.print( "Side 2: " );
			double side2 = input.nextDouble();
			System.out.print( "Side 3: " );
			double side3 = input.nextDouble();
			// -------
			// Weird bug where this nextLine() is needed to read the string value
			// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
			// -------
			input.nextLine();
			System.out.print( "Color: " );
			String color = input.nextLine();
			System.out.print( "Filled: " );
			boolean filled = input.nextBoolean();
			Triangle triangle = new Triangle( side1, side2, side3, color, filled );
			System.out.print( triangle.toString() );
		} catch ( java.util.InputMismatchException ex ) {
			System.out.println( "[!] Error: wrong data type entered" );
		}
	}
}