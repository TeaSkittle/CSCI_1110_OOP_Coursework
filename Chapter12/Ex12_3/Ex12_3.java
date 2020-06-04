// (c) Travis Dowd
// (d) 6-4-2020
//
// Chapter 12 exercise 12-3

import java.util.Scanner;
import java.lang.Math;

class Ex12_3 {
	public static void main( String[] args ) {
		int[] intArray = new int[ 100 ];
		for ( int i = 0; i < 100; i++ ) {
			// set intArray[ i ] to random int value between 1 - 3 digits
			intArray[ i ] = ( int )( Math.random() * 1000 );
		}
		try ( Scanner input = new Scanner ( System.in )) {
			System.out.print( "Enter an integer: " );
			int number = input.nextInt();
			System.out.printf( "array[ %d ]: %d \n",number, intArray[ number ] );
		} catch ( ArrayIndexOutOfBoundsException ex ) {
			System.out.println( "Error: Integer must be between 0 - 99" );
		}
	}
}