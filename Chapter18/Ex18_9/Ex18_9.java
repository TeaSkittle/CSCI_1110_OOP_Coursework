// (c) Travis Dowd
// (d) 7-14-2020
//
// Chapter 18, exercise 9

import java.util.Scanner;

class Ex18_9 {
	public static void main( String[] args ) {
		Scanner input =  new Scanner( System.in );
		System.out.print( "Enter a string: ");
		String value = input.nextLine();
		reverseDisplay( value );
	}
	public static void reverseDisplay( String value ){
		if( value.length() == 1 ){
			System.out.println( value );
		} else {
			String[] strArray = value.split( "" );
			String str = value.substring( 0, value.length() -1 );
			System.out.print( strArray[ value.length() - 1 ]);
			reverseDisplay( str );
		}
	}
}