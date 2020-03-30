// Author: Travis Dowd
// Date: 3-30-2020
// Chapter 9, exercise 9-1

public class Ex9_1 {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle( 4, 40 );
		Rectangle rec2 = new Rectangle( 3.5, 35.9 );
		// Rectangle 1
		System.out.println( "Rectangle 1:" );
		System.out.println( "Width: " + rec1.width );
		System.out.println( "Height: " + rec1.height );
		System.out.println( "Area: " + rec1.getArea() );
		System.out.println( "Perimeter: " + rec1.getPerimeter() );
		System.out.print( "\n" );
		// Rectangle 2
		System.out.println( "Rectangle 2:" );
		System.out.println( "Width: " + rec2.width );
		System.out.println( "Height: " + rec2.height );
		System.out.println( "Area: " + rec2.getArea() );
		System.out.println( "Perimeter: " + rec2.getPerimeter() );
	}
}