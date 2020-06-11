// (c) Travis Dowd
// (d) 6-9-2020
//
// Chapter 13, exercise 13-7

package Ex13_7;

import java.util.Scanner;

class test {
	public static void main( String[] args ) {
		GeometricObject[] obj = new GeometricObject[ 5 ];
		obj[ 0 ] = new Triangle( 9, 8, 7, "orange", true );
		obj[ 1 ] = new Triangle( 3, 4, 5, "red", true );
		obj[ 2 ] = new Triangle( 5, 7, 6.5, null, false );
		obj[ 3 ] = new Triangle( 5.5, 5.7, 3.2, null, false );
		obj[ 4 ] = new Triangle( 12, 13, 19, "yellow", false );
		for( int i = 0; i < 5; i++ ) {
			System.out.printf( "obj[ %d ]\n", i );
			System.out.println( "Area: " + obj[ i ].getArea() );
			System.out.print( "How to color: " );
			if ( obj[ i ].getColor() != null ) {
				// NOTE: These parenthesis were needed to call explicitly
				// https://stackoverflow.com/questions/13486529/cannot-find-symbol-method-but-the-method-is-declared
				(( Triangle ) obj[ i ] ).howToColor();
			} else {
				System.out.println( "Not colorable" );
			} System.out.printf( "\n" );
		}
	}
}