// (c) Travis Dowd
// (d) 5-1-2020 ( modified on 6-9-2020 )
//
// Chapter 13, exercise 13-7

package Ex13_7;

import java.lang.Math;

public class Triangle extends GeometricObject implements Colorable {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	Triangle(){}
	Triangle( double side1, double side2, double side3, String color, boolean filled ){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		setColor( color );
		setFilled( filled );
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	public double getArea() {
		double s = getPerimeter() / 2;
		double x = s * ( s-side1 ) * ( s-side2 ) * ( s-side3 );
		return Math.sqrt( x );
	}
	@Override
	public String toString() {
		return "\nArea: " + getArea() + "\nPermimeter: " + getPerimeter() + 
		"\nColor: " + getColor() + "\nFilled: " + isFilled();
	}
}