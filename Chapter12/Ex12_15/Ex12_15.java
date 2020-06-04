// (c) Travis Dowd
// (d) 6-4-2020
//
// Chapter 12 exercise 12-15

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.io.*;

class Ex12_15 {
	public static void main( String[] args ) throws IOException {
		// Array to write to file
		int[] intArray = new int[ 100 ];
		for ( int i = 0; i < 100; i++ ) {
			intArray[ i ] = ( int )( Math.random() * 1000 );
		}
		// -------------
		// Write to file
		// -------------
		File file = new java.io.File( "Exercise12_15.txt" );
		// Check for file
		if ( file.exists() ) {
			System.out.println( "File already exists" );
			System.exit( 1 );
		}
		// Else, continue
		PrintWriter output = new PrintWriter( file );
		for( int i: intArray ) {
			  output.print( i + " " );
		}
		output.close();
		// --------------
		// Read from file
		// --------------
		int[] sortedArray = new int[ intArray.length ];
		int e = 0;
		Scanner input = new Scanner ( file );
		while ( input.hasNext() ) {
			int number = input.nextInt();
			sortedArray[ e ] = number;
			e++;
		}
		input.close();
		// Print sorted numbers
		Arrays.sort( sortedArray );
		for ( int i: sortedArray ) {
			System.out.println( i );
		}
	}
}