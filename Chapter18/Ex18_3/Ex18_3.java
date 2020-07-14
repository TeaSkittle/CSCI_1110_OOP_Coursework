// (c) Travis Dowd
// (d) 7-14-2020
//
// Chapter 18, exerise 18-3

import java.util.Scanner;

class Ex18_3 {
	public static void main( String[] args ) {
		Scanner input = new Scanner( System.in );
		System.out.print( "Integer one: " );
		int a = input.nextInt();
		System.out.print( "Integer two: " );
		int b = input.nextInt();
		System.out.println("Greatest common divisor: "+ gcd( a, b ));
	}
	// Recursively find the Greatest Common Divisor of two integers
	public static int gcd( int m, int n ) {
		if( m % n == 0 ){
			return n;
		} else {
			return gcd( n, m % n );
		}
	}
}